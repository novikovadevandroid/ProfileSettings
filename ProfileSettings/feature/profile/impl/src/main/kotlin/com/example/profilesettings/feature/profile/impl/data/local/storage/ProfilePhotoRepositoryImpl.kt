package com.example.profilesettings.feature.profile.impl.data.local.storage

import android.content.Context
import android.net.Uri
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.util.UUID
import javax.inject.Inject

class ProfilePhotoStorage @Inject constructor(
    private val context: Context
) {

    suspend fun savePhoto(uri: Uri): String = withContext(Dispatchers.IO) {
        val directory = File(context.filesDir, PHOTO_DIRECTORY)

        if (!directory.exists()) {
            check(directory.mkdirs()) { CREATE_DIRECTORY_EXCEPTION }
        }

        val fileExtension = getFileExtension(uri)
        val photoFile = File(
            directory,
            "profile_${UUID.randomUUID()}.$fileExtension"
        )

        val inputStream = requireNotNull(
            context.contentResolver.openInputStream(uri)
        ) {
            UNABLE_OPEN_FILE_EXCEPTION
        }

        inputStream.use { input ->
            photoFile.outputStream().use { output ->
                input.copyTo(output)
            }
        }

        photoFile.absolutePath
    }

    fun deletePhoto(path: String?) {
        if (path.isNullOrBlank()) return

        val photoDirectory = File(context.filesDir, PHOTO_DIRECTORY)
        val photoFile = File(path)

        if (photoFile.parentFile == photoDirectory) {
            photoFile.delete()
        }
    }

    private fun getFileExtension(uri: Uri): String =
        when (context.contentResolver.getType(uri)) {
            "image/png" -> "png"
            "image/webp" -> "webp"
            "image/heic", "image/heif" -> "heic"
            else -> "jpg"
        }

    private companion object {
        const val PHOTO_DIRECTORY = "profile_photos"

        const val CREATE_DIRECTORY_EXCEPTION = "Failed to create photo directory"

        const val UNABLE_OPEN_FILE_EXCEPTION = "Unable to open selected image"
    }
}