package com.example.profilesettings.feature.profile.page.impl.presentation.compose

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.profilesettings.core.design.compose.ProfileTopBar
import com.example.profilesettings.feature.profile.page.impl.R
import com.example.profilesettings.feature.profile.page.impl.presentation.model.ProfilePageUi
import com.example.profilesettings.feature.profile.page.impl.presentation.model.ProfilePageUiState
import com.example.profilesettings.feature.profile.page.impl.presentation.viewmodel.ProfilePageViewModel
import java.io.File

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilePageScreen(
    viewModel: ProfilePageViewModel,
    onOpenSettings: () -> Unit
) {
    Log.d("TAG", "ProfilePageScreen")

    val state = viewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxSize(),
        topBar = {
            ProfileTopBar(R.string.edit) {
                onOpenSettings()
            }
        }
    ) { innerPadding ->
        when (val currentState = state.value) {
            is ProfilePageUiState.Error -> A()
            ProfilePageUiState.Initial -> A()
            ProfilePageUiState.Loading -> A()
            is ProfilePageUiState.Success -> ProfilePageContent(
                profile = currentState.profileUi,
                paddingValues = innerPadding
            )
        }
    }
}

// TODO: delete
@Composable
fun A() {
}

@Composable
fun ProfilePageContent(
    profile: ProfilePageUi?,
    paddingValues: PaddingValues
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValues)
    ) {
        item {
            Text(
                modifier = Modifier.padding(start = 16.dp, top = 8.dp),
                text = stringResource(R.string.your_profile),
                style = MaterialTheme.typography.displaySmall
            )
        }
        item {
            ProfilePhotoItem(photoFile = profile?.photo)
        }
    }
}

@Composable
private fun ProfilePhotoItem(
    photoFile: File?
) {
    if (photoFile == null) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(top = 8.dp)
                .background(MaterialTheme.colorScheme.surfaceContainer)
        )
    } else {
        AsyncImage(
            model = photoFile,
            contentDescription = stringResource(R.string.photo_title),
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(top = 8.dp),
            contentScale = ContentScale.Crop
        )
    }
}

