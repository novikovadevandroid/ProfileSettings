package com.example.profilesettings.presentation.compose.edit_profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.profilesettings.R

@Composable
fun EditProfileTopBar() {
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