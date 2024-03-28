import java.util.Properties

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.kapt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "com.example.pizza_test_task"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.pizza_test_task"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        val properties: Properties = Properties()
        properties.load(rootProject.file("local.properties").inputStream())

        buildConfigField("String", "BASE_URL", properties.getProperty("BASE_URL"))
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.viewbinding)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.coordinatorlayout)

    implementation(libs.bundles.room)
    ksp(libs.androidx.room.compiler)
    implementation(libs.airbnb.epoxy)
    kapt(libs.airbnb.epoxy.processor)

    implementation(libs.retrofit)
    implementation(libs.kotlinx.serialization)
    implementation(libs.kotlinx.serialization.converter)

    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    implementation(libs.coil)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}