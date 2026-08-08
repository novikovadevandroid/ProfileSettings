package com.example.profilesettings.feature.profile.impl.domain.usecase;

import com.example.profilesettings.feature.profile.impl.domain.repository.ProfilePhotoRepository;
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
public final class DeleteProfilePhotoUseCaseImpl_Factory implements Factory<DeleteProfilePhotoUseCaseImpl> {
  private final Provider<ProfilePhotoRepository> repositoryProvider;

  private DeleteProfilePhotoUseCaseImpl_Factory(
      Provider<ProfilePhotoRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public DeleteProfilePhotoUseCaseImpl get() {
    return newInstance(repositoryProvider.get());
  }

  public static DeleteProfilePhotoUseCaseImpl_Factory create(
      Provider<ProfilePhotoRepository> repositoryProvider) {
    return new DeleteProfilePhotoUseCaseImpl_Factory(repositoryProvider);
  }

  public static DeleteProfilePhotoUseCaseImpl newInstance(ProfilePhotoRepository repository) {
    return new DeleteProfilePhotoUseCaseImpl(repository);
  }
}
