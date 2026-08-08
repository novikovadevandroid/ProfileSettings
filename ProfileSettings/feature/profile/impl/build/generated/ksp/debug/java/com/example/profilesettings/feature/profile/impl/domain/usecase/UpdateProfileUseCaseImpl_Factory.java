package com.example.profilesettings.feature.profile.impl.domain.usecase;

import com.example.profilesettings.feature.profile.impl.domain.repository.ProfileRepository;
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
public final class UpdateProfileUseCaseImpl_Factory implements Factory<UpdateProfileUseCaseImpl> {
  private final Provider<ProfileRepository> repositoryProvider;

  private UpdateProfileUseCaseImpl_Factory(Provider<ProfileRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public UpdateProfileUseCaseImpl get() {
    return newInstance(repositoryProvider.get());
  }

  public static UpdateProfileUseCaseImpl_Factory create(
      Provider<ProfileRepository> repositoryProvider) {
    return new UpdateProfileUseCaseImpl_Factory(repositoryProvider);
  }

  public static UpdateProfileUseCaseImpl newInstance(ProfileRepository repository) {
    return new UpdateProfileUseCaseImpl(repository);
  }
}
