plugins {
    application
    id("java")
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
}