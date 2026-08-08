package com.example.profilesettings.feature.profile.impl.presentation.compose

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profilesettings.feature.profile.impl.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditInfoBottomSheet(
    title: String,
    value: String,
    onValueChange: (String) -> Unit,
    onUpdate: () -> Unit,
    onDismiss: () -> Unit
) {
    Log.d("TAG", "EditInfoBottomSheet")
    ModalBottomSheet(
        onDismissRequest = { onDismiss() }, containerColor = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 8.dp,
                    end = 8.dp,
                    bottom = 32.dp
                )
        ) {
            Text(
                text = title.lowercase().capitalize(Locale.current),
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = value,
                onValueChange = onValueChange
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onUpdate
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 4.dp),
                    text = stringResource(R.string.update),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Preview
@Composable
private fun EditInfoBottomSheetPreview() {
    EditInfoBottomSheet(
        TEST_TITLE,
        TEST_INFO,
        {},
        {},
        {}
    )
}

private const val TEST_TITLE = "Enter name"
private const val TEST_INFO = "Anna"