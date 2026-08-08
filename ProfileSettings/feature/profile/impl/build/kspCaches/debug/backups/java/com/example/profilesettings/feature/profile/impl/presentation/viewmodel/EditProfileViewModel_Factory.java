package com.example.profilesettings.feature.profile.impl.presentation.viewmodel;

import com.example.profilesettings.feature.profile.impl.domain.usecase.DeleteProfilePhotoUseCase;
import com.example.profilesettings.feature.profile.impl.domain.usecase.GetProfileUseCase;
import com.example.profilesettings.feature.profile.impl.domain.usecase.SaveProfilePhotoUseCase;
import com.example.profilesettings.feature.profile.impl.domain.usecase.SaveProfileUseCaseImpl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class EditProfileViewModel_Factory implements Factory<EditProfileViewModel> {
  private final Provider<GetProfileUseCase> getProfileUseCaseProvider;

  private final Provider<SaveProfileUseCaseImpl> saveProfileUseCaseProvider;

  private final Provider<SaveProfilePhotoUseCase> saveProfilePhotoUseCaseProvider;

  private final Provider<DeleteProfilePhotoUseCase> deleteProfilePhotoUseCaseProvider;

  private EditProfileViewModel_Factory(Provider<GetProfileUseCase> getProfileUseCaseProvider,
      Provider<SaveProfileUseCaseImpl> saveProfileUseCaseProvider,
      Provider<SaveProfilePhotoUseCase> saveProfilePhotoUseCaseProvider,
      Provider<DeleteProfilePhotoUseCase> deleteProfilePhotoUseCaseProvider) {
    this.getProfileUseCaseProvider = getProfileUseCaseProvider;
    this.saveProfileUseCaseProvider = saveProfileUseCaseProvider;
    this.saveProfilePhotoUseCaseProvider = saveProfilePhotoUseCaseProvider;
    this.deleteProfilePhotoUseCaseProvider = deleteProfilePhotoUseCaseProvider;
  }

  @Override
  public EditProfileViewModel get() {
    return newInstance(getProfileUseCaseProvider.get(), saveProfileUseCaseProvider.get(), saveProfilePhotoUseCaseProvider.get(), deleteProfilePhotoUseCaseProvider.get());
  }

  public static EditProfileViewModel_Factory create(
      Provider<GetProfileUseCase> getProfileUseCaseProvider,
      Provider<SaveProfileUseCaseImpl> saveProfileUseCaseProvider,
      Provider<SaveProfilePhotoUseCase> saveProfilePhotoUseCaseProvider,
      Provider<DeleteProfilePhotoUseCase> deleteProfilePhotoUseCaseProvider) {
    return new EditProfileViewModel_Factory(getProfileUseCaseProvider, saveProfileUseCaseProvider, saveProfilePhotoUseCaseProvider, deleteProfilePhotoUseCaseProvider);
  }

  public static EditProfileViewModel newInstance(GetProfileUseCase getProfileUseCase,
      SaveProfileUseCaseImpl saveProfileUseCase, SaveProfilePhotoUseCase saveProfilePhotoUseCase,
      DeleteProfilePhotoUseCase deleteProfilePhotoUseCase) {
    return new EditProfileViewModel(getProfileUseCase, saveProfileUseCase, saveProfilePhotoUseCase, deleteProfilePhotoUseCase);
  }
}
