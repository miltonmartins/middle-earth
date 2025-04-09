import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.kotlinSerialization) apply false
}

fun Project.loadLocalProperty(
    path: String,
    propertyName: String,
): String {
    val localProperties = Properties()
    val localPropertiesFile = project.rootProject.file(path)
    if (localPropertiesFile.exists()) {
        localProperties.load(localPropertiesFile.inputStream())
        return localProperties.getProperty(propertyName) ?: "\"NOT_FOUND\""
    } else {
        return "\"NOT_FOUND\""
    }
}