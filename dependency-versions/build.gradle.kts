plugins {
    id("java-platform")
}

javaPlatform.allowDependencies()

dependencies {
    api(platform("org.springframework.boot:spring-boot-dependencies:3.1.4"))
}

dependencies.constraints {
    api("org.apache.commons:commons-lang3:3.13.0") {
        // version { require("3.13.0") }
    }
    api("org.apache.commons:commons-text:1.5")
    api("org.slf4j:slf4j-api:2.0.7")
    api("org.slf4j:slf4j-simple:2.0.7")
}
