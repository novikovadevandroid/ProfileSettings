pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "EditProfileSettings"
include(":app")
include(":core:database")
include(":core:viewmodel")
include(":core:design")
include(":feature:profile:core:api")
include(":feature:profile:core:impl")
include(":feature:profile:page:api")
include(":feature:profile:page:impl")
include(":feature:profile:settings:api")
include(":feature:profile:settings:impl")