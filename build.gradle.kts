plugins {
    id("java")
}

group = "qa.qury"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("com.codeborne:selenide:7.0.4")
}

tasks.test {
    useJUnitPlatform()
}