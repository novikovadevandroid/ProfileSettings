package com.example.profilesettings.feature.profile.impl.presentation.viewmodel

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profilesettings.feature.profile.impl.di.DaggerProfileComponent
import com.example.profilesettings.feature.profile.impl.di.ProfileComponent
import com.example.profilesettings.feature.profile.impl.domain.usecase.DeleteProfilePhotoUseCase
import com.example.profilesettings.feature.profile.impl.domain.usecase.GetProfileUseCase
import com.example.profilesettings.feature.profile.impl.domain.usecase.SaveProfilePhotoUseCase
import com.example.profilesettings.feature.profile.impl.domain.usecase.SaveProfileUseCaseImpl
import com.example.profilesettings.feature.profile.impl.presentation.converter.toEntity
import com.example.profilesettings.feature.profile.impl.presentation.converter.toUi
import com.example.profilesettings.feature.profile.impl.presentation.model.EditInfoUiState
import com.example.profilesettings.feature.profile.impl.presentation.model.EditProfileAction
import com.example.profilesettings.feature.profile.impl.presentation.model.EditProfileEffects
import com.example.profilesettings.feature.profile.impl.presentation.model.EditProfileUiState
import com.example.profilesettings.feature.profile.impl.presentation.model.InfoTitle
import com.example.profilesettings.feature.profile.impl.presentation.model.ProfileUi
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class EditProfileViewModel @Inject constructor(
    private val getProfileUseCase: GetProfileUseCase,
    private val saveProfileUseCase: SaveProfileUseCaseImpl,
    private val saveProfilePhotoUseCase: SaveProfilePhotoUseCase,
    private val deleteProfilePhotoUseCase: DeleteProfilePhotoUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<EditProfileUiState>(EditProfileUiState.Initial)
    val state: StateFlow<EditProfileUiState>
        get() = _state.asStateFlow()

    private val _actions = MutableSharedFlow<EditProfileAction>()
    val actions: SharedFlow<EditProfileAction>
        get() = _actions.asSharedFlow()

    private val _editPhotoBottomSheet = MutableStateFlow(false)
    val editPhotoBottomSheet: StateFlow<Boolean>
        get() = _editPhotoBottomSheet.asStateFlow()

    private val _editInfoBottomSheet = MutableStateFlow(EditInfoUiState())
    val editInfoBottomSheet: StateFlow<EditInfoUiState>
        get() = _editInfoBottomSheet.asStateFlow()

    private val _effects = MutableSharedFlow<EditProfileEffects>()
    val effects = _effects.asSharedFlow()

    private var loadProfileJob: Job? = null

    init {
        viewModelScope.launch {
            loadProfile()
        }
    }

    private fun loadProfile() {
        Log.d("TAG", "loadProfile")
        loadProfileJob?.cancel()
        loadProfileJob = getProfileUseCase()
            .onStart {
                _state.value = EditProfileUiState.Loading
            }
            .onEach { profileEntity ->
                val profile = profileEntity?.toUi() ?: emptyProfile()
                _state.value = EditProfileUiState.Success(profile)
            }
            .catch { throwable ->
                _state.value = EditProfileUiState.Error(throwable.message.toString())
            }
            .launchIn(viewModelScope)
    }

    private fun emptyProfile(): ProfileUi {
        return ProfileUi(
            photo = null,
            name = "",
            email = "",
            title = "",
            location = ""
        )
    }

    fun saveProfile() {
        Log.d("TAG", "saveProfile")
        val currentState = _state.value

        if (currentState !is EditProfileUiState.Success) return

        val profile = currentState.profileUi ?: return

        viewModelScope.launch {
            saveProfileUseCase(profile.toEntity())
        }
    }

    fun updateProfile() {
        Log.d("TAG", "updateProfile")
        val sheetState = _editInfoBottomSheet.value
        val title = sheetState.title ?: return

        _state.update { currentState ->
            if (currentState !is EditProfileUiState.Success) {
                return@update currentState
            }

            val profile = currentState.profileUi
                ?: return@update currentState

            val updatedProfile = when (title) {
                InfoTitle.NAME -> profile.copy(
                    name = sheetState.value
                )

                InfoTitle.EMAIL -> profile.copy(
                    email = sheetState.value
                )

                InfoTitle.TITLE -> profile.copy(
                    title = sheetState.value
                )

                InfoTitle.LOCATION -> profile.copy(
                    location = sheetState.value
                )

                InfoTitle.EMPTY -> profile
            }

            EditProfileUiState.Success(
                profileUi = updatedProfile
            )
        }
        closeEditInfoBottomSheet()
    }

    fun onPhotoSelected(uri: Uri) {
        Log.d("TAG", "onPhotoSelected")
        viewModelScope.launch {
            runCatching {
                saveProfilePhotoUseCase(uri)
            }.onSuccess { photoPath ->
                updateProfilePhoto(photoPath)
                closeEditPhotoBottomSheet()
            }.onFailure {
                _effects.emit(EditProfileEffects.ShowToast(PHOTO_SAVE_EXCEPTION))
            }
        }
    }

    private fun updateProfilePhoto(photoPath: String) {
        Log.d("TAG", "updateProfilePhoto")
        _state.update { currentState ->
            if (currentState !is EditProfileUiState.Success) {
                return@update currentState
            }

            val currentProfile = currentState.profileUi ?: return@update currentState

            EditProfileUiState.Success(
                profileUi = currentProfile.copy(
                    photo = photoPath
                )
            )
        }
    }

    fun retryLoad() {
        loadProfile()
    }

    fun emitAction(action: EditProfileAction) {
        Log.d("TAG", "emitAction")
        viewModelScope.launch {
            _actions.emit(action)
        }
    }

    fun openEditPhotoBottomSheet() {
        Log.d("TAG", "openEditPhotoBottomSheet")
        _editPhotoBottomSheet.value = true
    }

    fun closeEditPhotoBottomSheet() {
        Log.d("TAG", "closeEditPhotoBottomSheet")
        _editPhotoBottomSheet.value = false
    }

    fun openEditInfoBottomSheet(title: InfoTitle, value: String?) {
        Log.d("TAG", "openEditInfoBottomSheet")
        _editInfoBottomSheet.update {
            EditInfoUiState(
                isVisible = true,
                title = title,
                value = value.orEmpty()
            )
        }
    }

    fun closeEditInfoBottomSheet() {
        Log.d("TAG", "closeEditInfoBottomSheet")
        val currentSheetState = _editInfoBottomSheet.value
        _editInfoBottomSheet.value = EditInfoUiState(
            isVisible = false,
            title = currentSheetState.title,
            value = currentSheetState.value
        )
    }

    fun changeEditInfoValue(value: String) {
        Log.d("TAG", "changeEditInfoValue")
        _editInfoBottomSheet.update { state ->
            state.copy(value = value)
        }
    }

    companion object {
        const val PHOTO_SAVE_EXCEPTION = "Unable to update photo. Please try again"
    }
}