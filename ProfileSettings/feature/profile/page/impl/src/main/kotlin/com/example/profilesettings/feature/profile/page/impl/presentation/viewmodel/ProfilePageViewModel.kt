package com.example.profilesettings.feature.profile.page.impl.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profilesettings.feature.profile.core.api.domain.GetProfileUseCase
import com.example.profilesettings.feature.profile.core.api.domain.ProfileEntity
import com.example.profilesettings.feature.profile.page.impl.presentation.converter.ProfilePagePresentationConverter
import com.example.profilesettings.feature.profile.page.impl.presentation.model.ProfilePageUi
import com.example.profilesettings.feature.profile.page.impl.presentation.model.ProfilePageUiState
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProfilePageViewModel @Inject constructor(
    private val getProfileUseCase: GetProfileUseCase,
    private val converter: ProfilePagePresentationConverter
) : ViewModel() {

    private val _state = MutableStateFlow<ProfilePageUiState>(ProfilePageUiState.Initial)
    val state: StateFlow<ProfilePageUiState>
        get() = _state.asStateFlow()

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
                _state.value = ProfilePageUiState.Loading
            }
            .onEach { profileEntity ->
                val profile = converter.convertEntityToUi(profileEntity ?: emptyEntityProfile())
                _state.value = ProfilePageUiState.Success(profile)
            }
            .catch { throwable ->
                _state.value = ProfilePageUiState.Error(throwable.message.toString())
            }
            .launchIn(viewModelScope)
    }

    private fun emptyEntityProfile(): ProfileEntity {
        return ProfileEntity(
            photo = "",
            name = "",
            email = "",
            title = "",
            location = ""
        )
    }
}