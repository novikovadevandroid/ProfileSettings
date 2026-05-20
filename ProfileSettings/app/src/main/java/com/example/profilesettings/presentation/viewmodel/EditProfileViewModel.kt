package com.example.profilesettings.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profilesettings.domain.usecase.GetProfileUseCase
import com.example.profilesettings.models.presentation.EditProfileAction
import com.example.profilesettings.models.presentation.EditProfileState
import com.example.profilesettings.presentation.converter.toUi
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
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
import kotlinx.coroutines.launch
import javax.inject.Inject

class EditProfileViewModel @Inject constructor(
    private val getProfileUseCase: GetProfileUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<EditProfileState>(EditProfileState.Initial)
    val state: StateFlow<EditProfileState>
        get() = _state.asStateFlow()

    private val _actions = MutableSharedFlow<EditProfileAction>()
    val actions: SharedFlow<EditProfileAction>
        get() = _actions.asSharedFlow()

    private val _bottomSheet = MutableStateFlow<Boolean>(false)
    val bottomSheet: SharedFlow<Boolean>
        get() = _bottomSheet.asStateFlow()

    private var loadProfileJob: Job? = null

    init {
        viewModelScope.launch {
            loadProfile()
        }
    }

    private fun loadProfile() {
        loadProfileJob?.cancel()
        loadProfileJob = getProfileUseCase()
            .onStart {
                _state.value = EditProfileState.Loading
            }
            .onEach { profileEntity ->
                delay(TIME_MILLIS)
                _state.value = EditProfileState.Success(profileEntity?.toUi())
            }
            .catch { throwable ->
                _state.value = EditProfileState.Error(throwable.message.toString())
            }
            .launchIn(viewModelScope)
    }

    fun retryLoad() {
        loadProfile()
    }

    fun emitAction(action: EditProfileAction) {
        viewModelScope.launch {
            _actions.emit(action)
        }
    }

    fun openBottomSheet() {
        _bottomSheet.value = true
    }

    fun closeBottomSheet() {
        _bottomSheet.value = false
    }

    private companion object {
        const val TIME_MILLIS = 2000L
    }
}