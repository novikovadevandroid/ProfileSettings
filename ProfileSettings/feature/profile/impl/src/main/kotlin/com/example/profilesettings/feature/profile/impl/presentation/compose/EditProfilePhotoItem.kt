package com.example.profilesettings.feature.profile.impl.presentation.compose

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.profilesettings.feature.profile.impl.R
import java.io.File

@Composable
fun EditProfilePhotoItem(
    photoPath: String?,
    onEditPhotoClick: () -> Unit
) {
    Log.d("TAG", "EditProfilePhotoItem")
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
            if (photoPath.isNullOrBlank()) {
                Box(
                    modifier = Modifier
                        .size(180.dp, 180.dp)
                        .background(
                            color = MaterialTheme.colorScheme.primaryContainer,
                            shape = CircleShape
                        )
                )
            } else {
                val photoFile: File? = if (photoPath.isNotBlank()) {
                    File(photoPath)
                } else {
                    null
                }

                AsyncImage(
                    model = photoFile,
                    contentDescription = "Profile photo",
                    modifier = Modifier
                        .size(180.dp, 180.dp)
                        .clip(shape = CircleShape),
                    contentScale = ContentScale.Crop
                )
            }

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