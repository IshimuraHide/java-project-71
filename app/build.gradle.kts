import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    application
    id("jacoco")
    id("java")
    id("checkstyle")
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"


application { mainClass.set("hexlet.code.App") }



repositories {
    mavenCentral()
}

dependencies {
    implementation ("info.picocli:picocli:4.7.6")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.18.0")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
    // https://technology.lastminute.com/junit5-kotlin-and-gradle-dsl/
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        // showStackTraces = true
        // showCauses = true
        showStandardStreams = true
    }
}

tasks.jacocoTestReport { reports { xml.required.set(true) } }
