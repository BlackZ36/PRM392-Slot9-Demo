plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.prm392_slot9_demo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.prm392_slot9_demo"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation("com.android.volley:volley:1.2.1")
    implementation("com.google.code.gson:gson:2.8.8")
    implementation("com.squareup.picasso:picasso:2.71828")
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

}