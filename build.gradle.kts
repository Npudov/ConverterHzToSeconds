plugins {
    id("java")
    id("org.springframework.boot") version "2.5.0"
}

apply(plugin = "io.spring.dependency-management")

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")

    testImplementation("org.springframework.boot:spring-boot-test:2.7.0")

    implementation ("org.springframework.boot:spring-boot-starter-web")


    implementation("jakarta.servlet:jakarta.servlet-api:6.0.0")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}