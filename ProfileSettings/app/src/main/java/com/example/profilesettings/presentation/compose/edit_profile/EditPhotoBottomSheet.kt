package com.example.profilesettings.presentation.compose.edit_profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profilesettings.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditPhotoBottomSheet(
    onCloseBottomSheet: (() -> Unit)? = null
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomEnd)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .background(
                        color = MaterialTheme.colorScheme.background,
                        shape = MaterialTheme.shapes.medium
                    )
            ) {
                EditPhotoItem(
                    text = stringResource(R.string.make_photo)
                ) { }
                HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
                EditPhotoItem(
                    text = stringResource(R.string.chose_photo)
                ) { }
            }
            EditPhotoItem(
                text = stringResource(R.string.cancel)
            ) { onCloseBottomSheet?.invoke() }
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
private fun EditPhotoItem(
    text: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 8.dp,
                vertical = 8.dp
            )
            .clip(MaterialTheme.shapes.medium)
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = MaterialTheme.shapes.medium
            )
            .clickable {
                onClick()
            }
    ) {
        Text(
            modifier = Modifier.padding(
                horizontal = 16.dp,
                vertical = 16.dp
            ),
            text = text,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview
@Composable
private fun EditPhotoBottomSheetPreview() {
    EditPhotoBottomSheet()
}