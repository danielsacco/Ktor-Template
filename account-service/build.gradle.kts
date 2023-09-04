import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import com.onegravity.Dependency

val applicationClass = "com.onegravity.accountservice.ApplicationKt"

plugins {
    application
    kotlin("jvm")

    // enable these two for kotlinx.serialization
    kotlin("plugin.serialization")
    kotlin("kapt")

    // for unknown reasons we need to use the fully qualified name for the plugin versions
    // importing com.onegravity.Plugin doesn't help
    //com.onegravity.Plugin.modulePlugins.forEach { (n, v) -> id(n) version v }
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

dependencies {
    implementation(project(":common"))

    //Dependency.implementation.forEach(::implementation)
    // Ktor Server
    implementation("io.ktor:ktor-server-core:1.6.8eap-339")
    implementation("io.ktor:ktor-server-netty:1.6.8")

    // Monitoring metrics
    implementation("io.ktor:ktor-metrics:1.6.7")
    implementation("io.ktor:ktor-metrics-micrometer:1.6.7")

    // Security
    implementation("io.ktor:ktor-auth:1.6.7")
    implementation("io.ktor:ktor-auth-jwt:1.6.7")

    // Koin / Dependency Injection
    implementation("io.insert-koin:koin-ktor:3.1.5")
    implementation("io.insert-koin:koin-logger-slf4j:3.1.5")

    // Kotlinx Serialization / Deserialization
    implementation("io.ktor:ktor-serialization:1.6.7")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.2")
    // GSON Serialization / Deserialization
    implementation("io.ktor:ktor-gson:1.6.7")
    // Moshi
    implementation("com.squareup.moshi:moshi-kotlin:1.13.0")

    // Postgres
    implementation("org.postgresql:postgresql:42.3.8")
    // Ktorm (ORM)
    implementation("org.ktorm:ktorm-core:3.4.1")
    implementation("org.ktorm:ktorm-support-postgresql:3.4.1")
    implementation("org.ktorm:ktorm-jackson:3.4.1")
    // Exposed (ORM)
    implementation("org.jetbrains.exposed:exposed:0.17.14")
    // HikariCP (Connection Pooling)
    implementation("com.zaxxer:HikariCP:4.0.3")
    // Flyway (DB migration)
    implementation("org.flywaydb:flyway-core:8.5.0")

    // OpenAPI Generator
    implementation("com.github.1gravity:Ktor-OpenAPI-Generator:0.2-beta.20")

    // Miscellaneous
    implementation("io.github.cdimascio:dotenv-kotlin:6.2.2")

    // Logging
    implementation("ch.qos.logback:logback-classic:1.2.10")

    //Dependency.runtime.forEach(::runtimeOnly)

    //Dependency.testImplementation.forEach(::testImplementation)
    testImplementation("io.ktor:ktor-server-tests:1.6.8")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.5.31")

    // Kotest
    testImplementation("io.kotest:kotest-runner-junit5:5.1.0")
    testImplementation("io.kotest:kotest-assertions-core:5.1.0")
    testImplementation("io.kotest:kotest-property:5.1.0")
    testImplementation("io.kotest:kotest-assertions-json:5.1.0")

    // Testcontainers for Postgres
    testImplementation("org.testcontainers:junit-jupiter:1.16.3")
    testImplementation("org.testcontainers:postgresql:1.16.3")
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
