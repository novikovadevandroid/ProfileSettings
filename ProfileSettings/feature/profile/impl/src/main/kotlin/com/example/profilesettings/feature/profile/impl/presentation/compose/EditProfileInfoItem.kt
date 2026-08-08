package com.example.profilesettings.feature.profile.impl.presentation.compose

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
import com.example.profilesettings.feature.profile.impl.R
import com.example.profilesettings.feature.profile.impl.presentation.model.InfoTitle

@Composable
fun EditProfileInfoItem(
    title: InfoTitle,
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
private fun InfoTitle.displayName(): String = when (this) {
    InfoTitle.NAME -> stringResource(R.string.name_title)
    InfoTitle.EMAIL -> stringResource(R.string.email_title)
    InfoTitle.TITLE -> stringResource(R.string.title_title)
    InfoTitle.LOCATION -> stringResource(R.string.location_title)
    InfoTitle.EMPTY -> stringResource(R.string.empty_data)
}