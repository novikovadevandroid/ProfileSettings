package com.example.profilesettings.feature.profile.impl.presentation.compose

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable

@Composable
fun AnimatedVisibilityBottomSheet(
    isVisible: Boolean,
    content: @Composable () -> Unit
) {
    Log.d("TAG", "AnimatedVisibilityBottomSheet")
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically(
            initialOffsetY = { fullHeight ->
                fullHeight
            }
        ) + fadeIn(),

        exit = slideOutVertically(
            targetOffsetY = { fullHeight ->
                fullHeight
            }
        ) + fadeOut()
    ) {
        content()
    }
}