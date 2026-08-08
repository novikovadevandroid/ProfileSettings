package com.example.profilesettings.core.common.viewmodel;

import androidx.lifecycle.ViewModel;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Map;
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
public final class ViewModelFactory_Factory implements Factory<ViewModelFactory> {
  private final Provider<Map<Class<? extends ViewModel>, javax.inject.Provider<ViewModel>>> viewModelProvidersProvider;

  private ViewModelFactory_Factory(
      Provider<Map<Class<? extends ViewModel>, javax.inject.Provider<ViewModel>>> viewModelProvidersProvider) {
    this.viewModelProvidersProvider = viewModelProvidersProvider;
  }

  @Override
  public ViewModelFactory get() {
    return newInstance(viewModelProvidersProvider.get());
  }

  public static ViewModelFactory_Factory create(
      Provider<Map<Class<? extends ViewModel>, javax.inject.Provider<ViewModel>>> viewModelProvidersProvider) {
    return new ViewModelFactory_Factory(viewModelProvidersProvider);
  }

  public static ViewModelFactory newInstance(
      Map<Class<? extends ViewModel>, javax.inject.Provider<ViewModel>> viewModelProviders) {
    return new ViewModelFactory(viewModelProviders);
  }
}
