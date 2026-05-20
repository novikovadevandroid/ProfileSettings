package com.example.profilesettings.presentation.compose.edit_profile

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.profilesettings.R
import com.example.profilesettings.getApplicationComponent
import com.example.profilesettings.models.presentation.EditProfileAction
import com.example.profilesettings.models.presentation.EditProfileState
import com.example.profilesettings.models.presentation.ProfileUi
import com.example.profilesettings.presentation.viewmodel.EditProfileViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen() {

    val component = getApplicationComponent()
    val viewModel: EditProfileViewModel = viewModel(factory = component.getViewModelFactory())
    val state = viewModel.state.collectAsState()
    val openSheetState = viewModel.bottomSheet.collectAsState(false)

    LaunchedEffect(Unit) {
        viewModel.actions.collect { action ->
            when (action) {
                is EditProfileAction.OpenBottomSheet -> viewModel.openBottomSheet()
            }
        }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            EditProfileTopBar()
        }
    ) { innerPadding ->

        when (val currentState = state.value) {
            is EditProfileState.Error -> EditProfileError(
                message = currentState.message
            ) { viewModel.retryLoad() }

            EditProfileState.Initial -> {}
            EditProfileState.Loading -> EditProfileLoading()
            is EditProfileState.Success -> EditProfileContent(
                profile = currentState.profileUi,
                paddingValues = innerPadding,
            ) { viewModel.emitAction(EditProfileAction.OpenBottomSheet) }
        }

        if (openSheetState.value) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
                    .clickable {
                        viewModel.closeBottomSheet()
                    }
            )
        }

        AnimatedVisibility(
            visible = openSheetState.value,
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
            EditPhotoBottomSheet { viewModel.closeBottomSheet() }
        }
    }
}

@Composable
private fun EditProfileContent(
    profile: ProfileUi?,
    paddingValues: PaddingValues,
    onEditPhotoClick: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxWidth()
            .padding(paddingValues)
    ) {
        item {
            Text(
                modifier = Modifier.padding(start = 16.dp, top = 8.dp),
                text = stringResource(R.string.edit_profile),
                style = MaterialTheme.typography.displaySmall
            )
        }
        item {
            EditProfilePhotoItem(onEditPhotoClick)
        }
        item {
            EditProfileInfoItem(
                title = stringResource(R.string.name_title),
                info = profile?.name
            )
        }
        item {
            EditProfileInfoItem(
                title = stringResource(R.string.email_title),
                info = profile?.email
            )
        }
        item {
            EditProfileInfoItem(
                title = stringResource(R.string.title_title),
                info = profile?.title
            )
        }
        item {
            EditProfileInfoItem(
                title = stringResource(R.string.location_title),
                info = profile?.location,
                needDivider = false
            )
        }
    }
}

@Preview
@Composable
private fun EditProfilePreview() {
    EditProfileScreen()
}

