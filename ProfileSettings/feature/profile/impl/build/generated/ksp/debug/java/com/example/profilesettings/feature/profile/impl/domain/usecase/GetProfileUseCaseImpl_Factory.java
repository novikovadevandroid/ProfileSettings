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
public final class GetProfileUseCaseImpl_Factory implements Factory<GetProfileUseCaseImpl> {
  private final Provider<ProfileRepository> repositoryProvider;

  private GetProfileUseCaseImpl_Factory(Provider<ProfileRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetProfileUseCaseImpl get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetProfileUseCaseImpl_Factory create(
      Provider<ProfileRepository> repositoryProvider) {
    return new GetProfileUseCaseImpl_Factory(repositoryProvider);
  }

  public static GetProfileUseCaseImpl newInstance(ProfileRepository repository) {
    return new GetProfileUseCaseImpl(repository);
  }
}
