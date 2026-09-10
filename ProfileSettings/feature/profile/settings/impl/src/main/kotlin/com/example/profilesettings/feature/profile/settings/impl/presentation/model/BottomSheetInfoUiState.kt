package com.example.profilesettings.feature.profile.settings.impl.presentation.model

import com.example.profilesettings.feature.profile.page.api.presentation.ProfilePageInfoTitle

data class BottomSheetInfoUiState(
    val isVisible: Boolean = false,
    val title: ProfilePageInfoTitle? = null,
    val value: String = ""
)



