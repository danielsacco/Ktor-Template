plugins {
    java
    kotlin("jvm")
}

dependencies {
    implementation(kotlin("stdlib"))

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
