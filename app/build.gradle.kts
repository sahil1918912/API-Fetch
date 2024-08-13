plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
}

android {
    namespace = "com.example.e2logy_sahil"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.e2logy_sahil"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding =true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    //    ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.8.4")

    //    ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.8.4")

    //     retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
//     gson converter
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

//    Glide
    implementation ("com.github.bumptech.glide:glide:4.16.0")

//    implementation 'com.github.bumptech.glide:glide:4.15.1'
    kapt ("com.github.bumptech.glide:compiler:4.16.0")


}