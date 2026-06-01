plugins {
    id("my-kotlin-app")
}

kotlin {
    sourceSets {
        jvmMain {
            dependencies {
                api("org.example:model:1.0")
                implementation(project(":engine"))
                implementation("org.apache.commons:commons-csv:1.14.1")
                implementation("commons-io:commons-io:2.20.0")
                implementation("org.slf4j:slf4j-api:2.0.17")

                runtimeOnly(project(":renderer"))
                runtimeOnly("org.slf4j:slf4j-simple:2.0.17")
            }
        }
    }
}
