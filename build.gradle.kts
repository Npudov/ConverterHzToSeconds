plugins {
    id("java")
    id("org.springframework.boot") version "2.5.0"
    //id("io.spring.dependency-management")
}

apply(plugin = "io.spring.dependency-management")

group = "org.example"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
}

dependencies {
    testImplementation("io.rest-assured:rest-assured:4.3.0")
    testImplementation("io.rest-assured:json-path:4.3.0")
    testImplementation("io.rest-assured:xml-path:4.3.0")
    testImplementation("io.rest-assured:json-schema-validator:4.3.0")
    testImplementation("io.rest-assured:spring-mock-mvc:4.3.0")
    testImplementation("io.rest-assured:spring-web-test-client:4.3.0")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.2")


    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")


    implementation("org.projectlombok:lombok:1.18.24")

    testImplementation("org.springframework.boot:spring-boot-test:2.7.0")

    implementation ("org.springframework.boot:spring-boot-starter-web")

    implementation ("org.springframework.boot:spring-boot-starter-thymeleaf")

    implementation("jakarta.servlet:jakarta.servlet-api:6.0.0")

    implementation("org.springframework.boot:spring-boot-starter-webflux")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}