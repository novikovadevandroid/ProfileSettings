package com.example.profilesettings.feature.profile.impl.data.local.storage;

import android.content.Context;
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
public final class ProfilePhotoStorage_Factory implements Factory<ProfilePhotoStorage> {
  private final Provider<Context> contextProvider;

  private ProfilePhotoStorage_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public ProfilePhotoStorage get() {
    return newInstance(contextProvider.get());
  }

  public static ProfilePhotoStorage_Factory create(Provider<Context> contextProvider) {
    return new ProfilePhotoStorage_Factory(contextProvider);
  }

  public static ProfilePhotoStorage newInstance(Context context) {
    return new ProfilePhotoStorage(context);
  }
}
