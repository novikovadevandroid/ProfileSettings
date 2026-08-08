package com.example.profilesettings.feature.profile.impl.di;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.example.profilesettings.core.common.viewmodel.ViewModelFactory;
import com.example.profilesettings.feature.profile.api.ProfileDao;
import com.example.profilesettings.feature.profile.api.ProfileDependencies;
import com.example.profilesettings.feature.profile.impl.data.local.storage.ProfilePhotoStorage;
import com.example.profilesettings.feature.profile.impl.data.local.storage.ProfilePhotoStorage_Factory;
import com.example.profilesettings.feature.profile.impl.data.repository.ProfilePhotoRepositoryImpl;
import com.example.profilesettings.feature.profile.impl.data.repository.ProfilePhotoRepositoryImpl_Factory;
import com.example.profilesettings.feature.profile.impl.data.repository.ProfileRepositoryImpl;
import com.example.profilesettings.feature.profile.impl.data.repository.ProfileRepositoryImpl_Factory;
import com.example.profilesettings.feature.profile.impl.domain.usecase.DeleteProfilePhotoUseCaseImpl;
import com.example.profilesettings.feature.profile.impl.domain.usecase.DeleteProfilePhotoUseCaseImpl_Factory;
import com.example.profilesettings.feature.profile.impl.domain.usecase.GetProfileUseCaseImpl;
import com.example.profilesettings.feature.profile.impl.domain.usecase.GetProfileUseCaseImpl_Factory;
import com.example.profilesettings.feature.profile.impl.domain.usecase.SaveProfilePhotoUseCaseImpl;
import com.example.profilesettings.feature.profile.impl.domain.usecase.SaveProfilePhotoUseCaseImpl_Factory;
import com.example.profilesettings.feature.profile.impl.domain.usecase.SaveProfileUseCaseImpl;
import com.example.profilesettings.feature.profile.impl.domain.usecase.SaveProfileUseCaseImpl_Factory;
import com.example.profilesettings.feature.profile.impl.presentation.viewmodel.EditProfileViewModel;
import com.example.profilesettings.feature.profile.impl.presentation.viewmodel.EditProfileViewModel_Factory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Collections;
import java.util.Map;
import javax.annotation.processing.Generated;

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
public final class DaggerProfileComponent {
  private DaggerProfileComponent() {
  }

  public static ProfileComponent.Factory factory() {
    return new Factory();
  }

  private static final class Factory implements ProfileComponent.Factory {
    @Override
    public ProfileComponent create(ProfileDependencies dependencies) {
      Preconditions.checkNotNull(dependencies);
      return new ProfileComponentImpl(dependencies);
    }
  }

  private static final class ProfileComponentImpl implements ProfileComponent {
    private final ProfileComponentImpl profileComponentImpl = this;

    Provider<ProfileDao> profileDaoProvider;

    Provider<ProfileRepositoryImpl> profileRepositoryImplProvider;

    Provider<GetProfileUseCaseImpl> getProfileUseCaseImplProvider;

    Provider<SaveProfileUseCaseImpl> saveProfileUseCaseImplProvider;

    Provider<Context> applicationContextProvider;

    Provider<ProfilePhotoStorage> profilePhotoStorageProvider;

    Provider<ProfilePhotoRepositoryImpl> profilePhotoRepositoryImplProvider;

    Provider<SaveProfilePhotoUseCaseImpl> saveProfilePhotoUseCaseImplProvider;

    Provider<DeleteProfilePhotoUseCaseImpl> deleteProfilePhotoUseCaseImplProvider;

    Provider<EditProfileViewModel> editProfileViewModelProvider;

    ProfileComponentImpl(ProfileDependencies profileDependenciesParam) {

      initialize(profileDependenciesParam);

    }

    Map<Class<? extends ViewModel>, javax.inject.Provider<ViewModel>> mapOfClassOfAndProviderOfViewModel(
        ) {
      return Collections.<Class<? extends ViewModel>, javax.inject.Provider<ViewModel>>singletonMap(EditProfileViewModel.class, ((Provider) (editProfileViewModelProvider)));
    }

    ViewModelFactory viewModelFactory2() {
      return new ViewModelFactory(mapOfClassOfAndProviderOfViewModel());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final ProfileDependencies profileDependenciesParam) {
      this.profileDaoProvider = new ProfileDaoProvider(profileDependenciesParam);
      this.profileRepositoryImplProvider = ProfileRepositoryImpl_Factory.create(profileDaoProvider);
      this.getProfileUseCaseImplProvider = GetProfileUseCaseImpl_Factory.create(((Provider) (profileRepositoryImplProvider)));
      this.saveProfileUseCaseImplProvider = SaveProfileUseCaseImpl_Factory.create(((Provider) (profileRepositoryImplProvider)));
      this.applicationContextProvider = new ApplicationContextProvider(profileDependenciesParam);
      this.profilePhotoStorageProvider = ProfilePhotoStorage_Factory.create(applicationContextProvider);
      this.profilePhotoRepositoryImplProvider = ProfilePhotoRepositoryImpl_Factory.create(profilePhotoStorageProvider);
      this.saveProfilePhotoUseCaseImplProvider = SaveProfilePhotoUseCaseImpl_Factory.create(((Provider) (profilePhotoRepositoryImplProvider)));
      this.deleteProfilePhotoUseCaseImplProvider = DeleteProfilePhotoUseCaseImpl_Factory.create(((Provider) (profilePhotoRepositoryImplProvider)));
      this.editProfileViewModelProvider = EditProfileViewModel_Factory.create(((Provider) (getProfileUseCaseImplProvider)), saveProfileUseCaseImplProvider, ((Provider) (saveProfilePhotoUseCaseImplProvider)), ((Provider) (deleteProfilePhotoUseCaseImplProvider)));
    }

    @Override
    public androidx.lifecycle.ViewModelProvider.Factory viewModelFactory() {
      return viewModelFactory2();
    }

    private static final class ProfileDaoProvider implements Provider<ProfileDao> {
      private final ProfileDependencies profileDependencies;

      ProfileDaoProvider(ProfileDependencies profileDependencies) {
        this.profileDependencies = profileDependencies;
      }

      @Override
      public ProfileDao get() {
        return Preconditions.checkNotNullFromComponent(profileDependencies.profileDao());
      }
    }

    private static final class ApplicationContextProvider implements Provider<Context> {
      private final ProfileDependencies profileDependencies;

      ApplicationContextProvider(ProfileDependencies profileDependencies) {
        this.profileDependencies = profileDependencies;
      }

      @Override
      public Context get() {
        return Preconditions.checkNotNullFromComponent(profileDependencies.applicationContext());
      }
    }
  }
}
