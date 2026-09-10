package com.example.profilesettings.feature.profile.settings.impl.presentation.compose

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profilesettings.feature.profile.page.api.presentation.ProfilePageInfoTitle
import com.example.profilesettings.feature.profile.settings.impl.R

@Composable
fun EditProfileInfoItem(
    title: ProfilePageInfoTitle,
    info: String?,
    onClick: (String?) -> Unit,
    needDivider: Boolean = true
) {
    Log.d("TAG", "EditProfileInfoItem")
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 24.dp,
                    vertical = 24.dp
                )
                .clickable { onClick(info) },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = title.displayName(),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.2.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = info ?: stringResource(R.string.empty_data),
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
private fun ProfilePageInfoTitle.displayName(): String = when (this) {
    ProfilePageInfoTitle.NAME -> stringResource(R.string.name_title)
    ProfilePageInfoTitle.EMAIL -> stringResource(R.string.email_title)
    ProfilePageInfoTitle.TITLE -> stringResource(R.string.title_title)
    ProfilePageInfoTitle.LOCATION -> stringResource(R.string.location_title)
    ProfilePageInfoTitle.EMPTY -> stringResource(R.string.empty_data)
}