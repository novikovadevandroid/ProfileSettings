package com.example.profilesettings.feature.profile.impl.data.repository;

import com.example.profilesettings.feature.profile.impl.data.local.storage.ProfilePhotoStorage;
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
public final class ProfilePhotoRepositoryImpl_Factory implements Factory<ProfilePhotoRepositoryImpl> {
  private final Provider<ProfilePhotoStorage> storageProvider;

  private ProfilePhotoRepositoryImpl_Factory(Provider<ProfilePhotoStorage> storageProvider) {
    this.storageProvider = storageProvider;
  }

  @Override
  public ProfilePhotoRepositoryImpl get() {
    return newInstance(storageProvider.get());
  }

  public static ProfilePhotoRepositoryImpl_Factory create(
      Provider<ProfilePhotoStorage> storageProvider) {
    return new ProfilePhotoRepositoryImpl_Factory(storageProvider);
  }

  public static ProfilePhotoRepositoryImpl newInstance(ProfilePhotoStorage storage) {
    return new ProfilePhotoRepositoryImpl(storage);
  }
}
