rootProject.name = "ktor-template"

include(
    "common",
    "account-service"
    // more services go here
)

// referencing a local project goes like this:
// project(":OpenAPI-Generator").projectDir = File("../Ktor-OpenAPI-Generator")



dependencyResolutionManagement {
    versionCatalogs {

        create("libs") {
            version("kotlin", "1.9.10")
            version("ktor", "1.6.7")
            version("koin", "3.1.5")
            version("ktorm", "3.4.1")
            version("kotlinx", "1.3.2")
            version("kotest", "5.1.0")
            version("testcontainers", "1.16.3")

            library("ktor-metrics", "io.ktor", "ktor-metrics").versionRef("ktor")
            library("ktor-metrics-micrometer", "io.ktor", "ktor-metrics-micrometer").versionRef("ktor")
            library("ktor-server-netty", "io.ktor", "ktor-server-netty").versionRef("ktor")
            library("ktor-auth", "io.ktor", "ktor-auth").versionRef("ktor")
            library("ktor-auth-jwt", "io.ktor", "ktor-auth-jwt").versionRef("ktor")
            library("ktor-serialization", "io.ktor", "ktor-serialization").versionRef("ktor")
            library("ktor-gson", "io.ktor", "ktor-gson").versionRef("ktor")
            library("ktor-server-tests", "io.ktor", "ktor-server-tests").versionRef("ktor")
            library("ktor-server-core", "io.ktor", "ktor-server-core").versionRef("ktor")

            library("koin-ktor", "io.insert-koin", "koin-ktor").versionRef("koin")
            library("koin-logger-slf4j", "io.insert-koin", "koin-logger-slf4j").versionRef("koin")

            library("ktorm-core", "org.ktorm", "ktorm-core").versionRef("ktorm")
            library("ktorm-support-postgresql", "org.ktorm", "ktorm-support-postgresql").versionRef("ktorm")
            library("ktorm-jackson", "org.ktorm", "ktorm-jackson").versionRef("ktorm")

            library("kotlinx-serialization-core", "org.jetbrains.kotlinx", "kotlinx-serialization-core").versionRef("kotlinx")

            library("moshi-kotlin", "com.squareup.moshi", "moshi-kotlin").version("1.13.0")
            library("postgresql", "org.postgresql", "postgresql").version("42.3.8")
            library("exposed", "org.jetbrains.exposed", "exposed").version("0.17.14")
            library("hikaricp", "com.zaxxer", "HikariCP").version("4.0.3")
            library("flyway-core", "org.flywaydb", "flyway-core").version("8.5.0")
            library("ktor-openapi-generator", "com.github.1gravity", "Ktor-OpenAPI-Generator").version("0.2-beta.20")
            library("dotenv-kotlin", "io.github.cdimascio", "dotenv-kotlin").version("6.2.2")
            library("logback-classic", "ch.qos.logback", "logback-classic").version("1.2.10")
            library("kotlin-test", "org.jetbrains.kotlin", "kotlin-test").version("1.5.31")

            library("kotest-runner-junit5", "io.kotest", "kotest-runner-junit5").versionRef("kotest")
            library("kotest-assertions-core", "io.kotest", "kotest-assertions-core").versionRef("kotest")
            library("kotest-property", "io.kotest", "kotest-property").versionRef("kotest")
            library("kotest-assertions-json", "io.kotest", "kotest-assertions-json").versionRef("kotest")

            library("testcontainers-junit-jupiter","org.testcontainers", "junit-jupiter").versionRef("testcontainers")
            library("testcontainers-postgresql","org.testcontainers", "postgresql").versionRef("testcontainers")

        }
    }
}

