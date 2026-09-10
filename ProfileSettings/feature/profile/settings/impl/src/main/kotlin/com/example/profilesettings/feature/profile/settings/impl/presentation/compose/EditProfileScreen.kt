package com.example.profilesettings.feature.profile.settings.impl.presentation.compose

import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.profilesettings.core.design.compose.ProfileTopBar
import com.example.profilesettings.feature.profile.page.api.presentation.ProfilePageInfoTitle
import com.example.profilesettings.feature.profile.settings.impl.R
import com.example.profilesettings.feature.profile.settings.impl.presentation.model.SettingsProfileAction
import com.example.profilesettings.feature.profile.settings.impl.presentation.model.SettingsProfileEffects
import com.example.profilesettings.feature.profile.settings.impl.presentation.model.SettingsProfileUi
import com.example.profilesettings.feature.profile.settings.impl.presentation.model.SettingsProfileUiState
import com.example.profilesettings.feature.profile.settings.impl.presentation.viewmodel.SettingsProfileViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(
    viewModel: SettingsProfileViewModel
) {
    Log.d("TAG", "EditProfileScreen")

    val state = viewModel.state.collectAsStateWithLifecycle()
    val editPhotoSheetState = viewModel.editPhotoBottomSheet.collectAsStateWithLifecycle()
    val editInfoSheetState = viewModel.editInfoBottomSheet.collectAsStateWithLifecycle()
    val currentInfoSheetState = editInfoSheetState.value

    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { uri ->
        uri?.let(viewModel::onPhotoSelected)
    }

    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.actions.collect { action ->
            when (action) {
                is SettingsProfileAction.OpenBottomSheet -> viewModel.openEditPhotoBottomSheet()
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.effects.collect { effect ->
            when (effect) {
                is SettingsProfileEffects.ShowToast -> Toast.makeText(
                    context,
                    effect.message,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    Scaffold(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxSize(),
        topBar = {
            ProfileTopBar(R.string.save) {
                viewModel.saveProfile()
            }
        }
    ) { innerPadding ->
        when (val currentState = state.value) {
            is SettingsProfileUiState.Error -> EditProfileError(
                message = currentState.message
            ) { viewModel.retryLoad() }

            SettingsProfileUiState.Initial -> {}
            SettingsProfileUiState.Loading -> EditProfileLoading()
            is SettingsProfileUiState.Success -> EditProfileContent(
                profile = currentState.profileUi,
                paddingValues = innerPadding,
                onEditPhotoClick = { viewModel.emitAction(SettingsProfileAction.OpenBottomSheet) },
                onEditInfoClick = { title, value ->
                    viewModel.openEditInfoBottomSheet(
                        title = title,
                        value = value
                    )
                }
            )
        }

        if (editPhotoSheetState.value) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
                    .clickable {
                        viewModel.closeEditPhotoBottomSheet()
                    }
            )
        }

        AnimatedVisibilityBottomSheet(
            isVisible = editPhotoSheetState.value
        ) {
            EditPhotoBottomSheet(
                onChoosePhotoClick = {
                    photoPickerLauncher.launch(
                        PickVisualMediaRequest(
                            ActivityResultContracts.PickVisualMedia.ImageOnly
                        )
                    )
                },
                onCloseBottomSheet = { viewModel.closeEditPhotoBottomSheet() }
            )
        }

        AnimatedVisibilityBottomSheet(
            isVisible = currentInfoSheetState.isVisible
        ) {
            EditInfoBottomSheet(
                title = when (currentInfoSheetState.title) {
                    ProfilePageInfoTitle.NAME -> stringResource(R.string.name_title)
                    ProfilePageInfoTitle.EMAIL -> stringResource(R.string.email_title)
                    ProfilePageInfoTitle.TITLE -> stringResource(R.string.title_title)
                    ProfilePageInfoTitle.LOCATION -> stringResource(R.string.location_title)
                    else -> {
                        stringResource(R.string.empty_data)
                    }
                },
                value = currentInfoSheetState.value,
                onValueChange = { viewModel.changeEditInfoValue(it) },
                onUpdate = { viewModel.updateProfile() },
                onDismiss = { viewModel.closeEditInfoBottomSheet() }
            )
        }
    }
}

@Composable
private fun EditProfileContent(
    profile: SettingsProfileUi?,
    paddingValues: PaddingValues,
    onEditPhotoClick: () -> Unit,
    onEditInfoClick: (ProfilePageInfoTitle, String) -> Unit
) {
    Log.d("TAG", "EditProfileContent")

    val nullStringRes = stringResource(R.string.empty_data)

    LazyColumn(
        modifier = Modifier
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
            EditProfilePhotoItem(
                photoFile = profile?.photo,
                onEditPhotoClick = onEditPhotoClick
            )
        }
        item {
            EditProfileInfoItem(
                title = ProfilePageInfoTitle.NAME,
                info = profile?.name,
                onClick = { value ->
                    onEditInfoClick(
                        ProfilePageInfoTitle.NAME,
                        value ?: nullStringRes
                    )
                }
            )
        }
        item {
            EditProfileInfoItem(
                title = ProfilePageInfoTitle.EMAIL,
                info = profile?.email,
                onClick = { value ->
                    onEditInfoClick(
                        ProfilePageInfoTitle.EMAIL,
                        value ?: nullStringRes
                    )
                }
            )
        }
        item {
            EditProfileInfoItem(
                title = ProfilePageInfoTitle.TITLE,
                info = profile?.title,
                onClick = { value ->
                    onEditInfoClick(
                        ProfilePageInfoTitle.TITLE,
                        value ?: nullStringRes
                    )
                }
            )
        }
        item {
            EditProfileInfoItem(
                title = ProfilePageInfoTitle.LOCATION,
                info = profile?.location,
                needDivider = false,
                onClick = { value ->
                    onEditInfoClick(
                        ProfilePageInfoTitle.LOCATION,
                        value ?: nullStringRes
                    )
                }
            )
        }
    }
}

