package com.example.profilesettings.feature.profile.impl.data.repository;

import com.example.profilesettings.feature.profile.api.ProfileDao;
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
public final class ProfileRepositoryImpl_Factory implements Factory<ProfileRepositoryImpl> {
  private final Provider<ProfileDao> daoProvider;

  private ProfileRepositoryImpl_Factory(Provider<ProfileDao> daoProvider) {
    this.daoProvider = daoProvider;
  }

  @Override
  public ProfileRepositoryImpl get() {
    return newInstance(daoProvider.get());
  }

  public static ProfileRepositoryImpl_Factory create(Provider<ProfileDao> daoProvider) {
    return new ProfileRepositoryImpl_Factory(daoProvider);
  }

  public static ProfileRepositoryImpl newInstance(ProfileDao dao) {
    return new ProfileRepositoryImpl(dao);
  }
}
