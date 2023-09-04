import com.onegravity.Plugin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // for unknown reasons we need to use the fully qualified name for the plugin versions
    // importing com.onegravity.Plugin doesn't help
    //com.onegravity.Plugin.topLevelPlugins.forEach { (n, v) -> id(n) version v }

    kotlin("jvm") version "1.8.22"
    kotlin("plugin.serialization") version "1.8.22"
    id("org.barfuin.gradle.taskinfo") version "1.3.1"
}

buildscript {
    repositories {
        mavenCentral()
    }
}

allprojects {
    repositories {
        mavenCentral()
        maven("https://jitpack.io")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn", "-Xuse-experimental=kotlin.ExperimentalStdlibApi")
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
