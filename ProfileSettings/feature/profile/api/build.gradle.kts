plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11)
    }
}

android {
    namespace = "com.example.profilesettings.feature.profile.api"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        minSdk = 24
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(project(":core:common"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.room)
    ksp(libs.room.compiler)
}

afterEvaluate {
    println(
        "profile api application = " +
                plugins.hasPlugin("com.android.application")
    )
    println(
        "profile api library = " +
                plugins.hasPlugin("com.android.library")
    )
    println(
        "profile api dynamic = " +
                plugins.hasPlugin("com.android.dynamic-feature")
    )
}