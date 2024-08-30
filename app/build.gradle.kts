plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
   // id("kotlin-kapt")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
   // id ("androidx.compose")
}

android {
    namespace = "com.example.question"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.question"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    //Coroutines
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)



    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.compiler)

    //hilt
    implementation( libs.dagger.hilt.android.v244)
    kapt (libs.dagger.hilt.android.compiler.v244)
    implementation(libs.google.hilt.android.v244)
    kapt(libs.google.hilt.android.compiler.v244)
    implementation  (libs.androidx.lifecycle.viewmodel.ktx.v251)// نسخه را به روز کنید
    kapt  (libs.androidx.lifecycle.compiler)

    // برای کار با Hilt در کلاس‌های
  //  implementation ("androidx.hilt:hilt-navigation-compose:1.2.0")
    implementation (libs.androidx.hilt.navigation.compose.v100)


    //retrofit
implementation(libs.retrofit.v290)
   // implementation (libs.retrofit)
    //GSON
implementation("com.squareup.retrofit2:converter-gson:2.9.0")

   // implementation (libs.converter.gson)



}

// Allow references to generated code
//kapt {
  ///  correctErrorTypes = true
//}

kapt {
correctErrorTypes = true
}
