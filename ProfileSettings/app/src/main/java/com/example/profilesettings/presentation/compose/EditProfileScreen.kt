package com.example.profilesettings.presentation.compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.profilesettings.R
import com.example.profilesettings.getApplicationComponent
import com.example.profilesettings.models.presentation.EditProfileAction
import com.example.profilesettings.models.presentation.ProfileUi
import com.example.profilesettings.presentation.EditProfileViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen() {

    val component = getApplicationComponent()
    val viewModel: EditProfileViewModel = viewModel(factory = component.getViewModelFactory())
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
        EditProfileContent(
            ProfileUi("name", "email", "title", "location"),
            innerPadding
        ) { viewModel.emitAction(EditProfileAction.OpenBottomSheet) }

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
    profile: ProfileUi,
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
                info = profile.name
            )
        }
        item {
            EditProfileInfoItem(
                title = stringResource(R.string.email_title),
                info = profile.email
            )
        }
        item {
            EditProfileInfoItem(
                title = stringResource(R.string.title_title),
                info = profile.title
            )
        }
        item {
            EditProfileInfoItem(
                title = stringResource(R.string.location_title),
                info = profile.location,
                needDivider = false
            )
        }
    }
}

@Composable
fun EditProfilePhotoItem(
    onEditPhotoClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(top = 8.dp)
            .background(MaterialTheme.colorScheme.surfaceContainer)
    ) {
        Icon(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 32.dp, end = 24.dp)
                .clickable { onEditPhotoClick() },
            imageVector = Icons.Outlined.Edit,
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomEnd),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(180.dp, 180.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primaryContainer,
                        shape = CircleShape
                    )
            )
            Text(
                modifier = Modifier.padding(16.dp),
                text = stringResource(R.string.photo_title),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.2.sp
            )
        }
    }
}

@Composable
private fun EditProfileInfoItem(
    title: String,
    info: String,
    needDivider: Boolean = true
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 24.dp,
                    vertical = 24.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.2.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = info,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Icon(
                modifier = Modifier.size(30.dp, 40.dp),
                imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                contentDescription = null
            )
        }
        if (needDivider) {
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
private fun EditProfileTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 8.dp, top = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            modifier = Modifier.size(30.dp, 30.dp),
            imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(end = 8.dp),
            text = stringResource(R.string.save),
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Preview
@Composable
private fun EditProfilePreview() {
    EditProfileScreen()
}

