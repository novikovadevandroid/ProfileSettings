package com.example.profilesettings.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profilesettings.models.presentation.EditProfileAction
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class EditProfileViewModel @Inject constructor() : ViewModel() {

    private val _actions = MutableSharedFlow<EditProfileAction>()
    val actions: SharedFlow<EditProfileAction>
        get() = _actions.asSharedFlow()

    private val _bottomSheet = MutableStateFlow<Boolean>(false)
    val bottomSheet: SharedFlow<Boolean>
        get() = _bottomSheet.asStateFlow()

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
}