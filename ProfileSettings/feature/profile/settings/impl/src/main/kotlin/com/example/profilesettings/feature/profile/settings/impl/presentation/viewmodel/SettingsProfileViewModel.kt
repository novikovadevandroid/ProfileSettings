package com.example.profilesettings.feature.profile.settings.impl.presentation.viewmodel

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profilesettings.feature.profile.core.api.domain.GetProfileUseCase
import com.example.profilesettings.feature.profile.core.api.domain.ProfileEntity
import com.example.profilesettings.feature.profile.core.api.utils.ProfileUtils
import com.example.profilesettings.feature.profile.page.api.presentation.ProfilePageInfoTitle
import com.example.profilesettings.feature.profile.settings.impl.domain.usecase.DeleteSettingsProfilePhotoUseCase
import com.example.profilesettings.feature.profile.settings.impl.domain.usecase.SaveSettingsProfilePhotoUseCase
import com.example.profilesettings.feature.profile.settings.impl.domain.usecase.SaveSettingsProfileUseCase
import com.example.profilesettings.feature.profile.settings.impl.presentation.converter.EditProfileUiConverter
import com.example.profilesettings.feature.profile.settings.impl.presentation.model.BottomSheetInfoUiState
import com.example.profilesettings.feature.profile.settings.impl.presentation.model.SettingsProfileAction
import com.example.profilesettings.feature.profile.settings.impl.presentation.model.SettingsProfileEffects
import com.example.profilesettings.feature.profile.settings.impl.presentation.model.SettingsProfileUi
import com.example.profilesettings.feature.profile.settings.impl.presentation.model.SettingsProfileUiState
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

class SettingsProfileViewModel @Inject constructor(
    private val getProfileUseCase: GetProfileUseCase,
    private val saveProfileUseCase: SaveSettingsProfileUseCase,
    private val saveProfilePhotoUseCase: SaveSettingsProfilePhotoUseCase,
    private val deleteProfilePhotoUseCase: DeleteSettingsProfilePhotoUseCase,
    private val converter: EditProfileUiConverter,
    private val utils: ProfileUtils
) : ViewModel() {

    private val _state = MutableStateFlow<SettingsProfileUiState>(SettingsProfileUiState.Initial)
    val state: StateFlow<SettingsProfileUiState>
        get() = _state.asStateFlow()

    private val _actions = MutableSharedFlow<SettingsProfileAction>()
    val actions: SharedFlow<SettingsProfileAction>
        get() = _actions.asSharedFlow()

    private val _editPhotoBottomSheet = MutableStateFlow(false)
    val editPhotoBottomSheet: StateFlow<Boolean>
        get() = _editPhotoBottomSheet.asStateFlow()

    private val _editInfoBottomSheet = MutableStateFlow(BottomSheetInfoUiState())
    val editInfoBottomSheet: StateFlow<BottomSheetInfoUiState>
        get() = _editInfoBottomSheet.asStateFlow()

    private val _effects = MutableSharedFlow<SettingsProfileEffects>()
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
                _state.value = SettingsProfileUiState.Loading
            }
            .onEach { profileEntity ->
                val profile = converter.convertToUi(profileEntity ?: emptyEntitySettingsProfile())
                _state.value = SettingsProfileUiState.Success(profile)
            }
            .catch { throwable ->
                _state.value = SettingsProfileUiState.Error(throwable.message.toString())
            }
            .launchIn(viewModelScope)
    }

    private fun emptyEntitySettingsProfile(): ProfileEntity {
        return ProfileEntity(
            photo = "",
            name = "",
            email = "",
            title = "",
            location = ""
        )
    }

    fun saveProfile() {
        Log.d("TAG", "saveProfile")
        val currentState = _state.value

        if (currentState !is SettingsProfileUiState.Success) return

        val profile = currentState.profileUi ?: return

        viewModelScope.launch {
            saveProfileUseCase(converter.convertToEntity(profile))
        }
    }

    fun updateProfile() {
        Log.d("TAG", "updateProfile")
        val sheetState = _editInfoBottomSheet.value
        val title = sheetState.title ?: return

        _state.update { currentState ->
            if (currentState !is SettingsProfileUiState.Success) {
                return@update currentState
            }

            val profile = currentState.profileUi
                ?: return@update currentState

            val updatedProfile = when (title) {
                ProfilePageInfoTitle.NAME -> profile.copy(
                    name = sheetState.value
                )

                ProfilePageInfoTitle.EMAIL -> profile.copy(
                    email = sheetState.value
                )

                ProfilePageInfoTitle.TITLE -> profile.copy(
                    title = sheetState.value
                )

                ProfilePageInfoTitle.LOCATION -> profile.copy(
                    location = sheetState.value
                )

                ProfilePageInfoTitle.EMPTY -> profile
            }

            SettingsProfileUiState.Success(
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
                _effects.emit(SettingsProfileEffects.ShowToast(PHOTO_SAVE_EXCEPTION))
            }
        }
    }

    private fun updateProfilePhoto(photoPath: String) {
        Log.d("TAG", "updateProfilePhoto")
        _state.update { currentState ->
            if (currentState !is SettingsProfileUiState.Success) {
                return@update currentState
            }

            val currentProfile = currentState.profileUi ?: return@update currentState

            SettingsProfileUiState.Success(
                profileUi = currentProfile.copy(
                    photo = utils.getFileFromProfilePhoto(photoPath)
                )
            )
        }
    }

    fun retryLoad() {
        loadProfile()
    }

    fun emitAction(action: SettingsProfileAction) {
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

    fun openEditInfoBottomSheet(title: ProfilePageInfoTitle, value: String?) {
        Log.d("TAG", "openEditInfoBottomSheet")
        _editInfoBottomSheet.update {
            BottomSheetInfoUiState(
                isVisible = true,
                title = title,
                value = value.orEmpty()
            )
        }
    }

    fun closeEditInfoBottomSheet() {
        Log.d("TAG", "closeEditInfoBottomSheet")
        val currentSheetState = _editInfoBottomSheet.value
        _editInfoBottomSheet.value = BottomSheetInfoUiState(
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

    companion object Companion {
        const val PHOTO_SAVE_EXCEPTION = "Unable to update photo. Please try again"
    }
}