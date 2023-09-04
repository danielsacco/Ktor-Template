import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

val applicationClass = "com.onegravity.accountservice.ApplicationKt"

plugins {
    application
    kotlin("jvm")

    // enable these two for kotlinx.serialization
    kotlin("plugin.serialization")
    kotlin("kapt")

    id("com.github.johnrengelman.shadow") version "7.1.2"
}

dependencies {
    implementation(project(":common"))

    // Ktor Server
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)

    // Monitoring metrics
    implementation(libs.ktor.metrics)
    implementation(libs.ktor.metrics.micrometer)

    // Security
    implementation(libs.ktor.auth)
    implementation(libs.ktor.auth.jwt)

    // Koin / Dependency Injection
    implementation(libs.koin.ktor)
    implementation(libs.koin.logger.slf4j)

    // Kotlinx Serialization / Deserialization
    implementation(libs.ktor.serialization)
    implementation(libs.kotlinx.serialization.core)
    // GSON Serialization / Deserialization
    implementation(libs.ktor.gson)
    // Moshi
    implementation(libs.moshi.kotlin)

    // Postgres
    implementation(libs.postgresql)
    // Ktorm (ORM)
    implementation(libs.ktorm.core)
    implementation(libs.ktorm.support.postgresql)
    implementation(libs.ktorm.jackson)
    // Exposed (ORM)
    implementation(libs.exposed)
    // HikariCP (Connection Pooling)
    implementation(libs.hikaricp)
    // Flyway (DB migration)
    implementation(libs.flyway.core)

    // OpenAPI Generator
    implementation(libs.ktor.openapi.generator)

    // Miscellaneous
    implementation(libs.dotenv.kotlin)

    // Logging
    implementation(libs.logback.classic)

    testImplementation(libs.ktor.server.tests)
    testImplementation(libs.kotlin.test)

    // Kotest
    testImplementation(libs.kotest.assertions.core)
    testImplementation(libs.kotest.assertions.json)
    testImplementation(libs.kotest.property)
    testImplementation(libs.kotest.runner.junit5)

    // Testcontainers for Postgres
    testImplementation(libs.testcontainers.junit.jupiter)
    testImplementation(libs.testcontainers.postgresql)
}

application {
    mainClass.set(applicationClass)
}

tasks {
    // alternative syntax: "shadowJar"(ShadowJar::class) {
    named<ShadowJar>("shadowJar") {
        archiveBaseName.set(project.name)
        archiveClassifier.set("")
        archiveVersion.set("")
        mergeServiceFiles()
        project.setProperty("mainClassName", applicationClass)
        manifest {
            attributes(mapOf("Main-Class" to applicationClass))
        }
    }
}

tasks.register("stage") {
    dependsOn("assemble", "clean")
    mustRunAfter("clean")
}
