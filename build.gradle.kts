import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.serialization") version "1.8.22"
    id("org.barfuin.gradle.taskinfo") version "2.1.0"
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
            jvmTarget = "17"
            freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn", "-Xuse-experimental=kotlin.ExperimentalStdlibApi")
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
