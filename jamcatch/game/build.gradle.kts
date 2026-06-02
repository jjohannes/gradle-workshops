plugins {
    id("my-kotlin-app")
}

kotlin {
    sourceSets {
        jvmMain {
            dependencies {
                api("org.example:model")
                implementation(project(":engine"))
                implementation(libs.commons.csv)
                implementation(libs.commons.io)
                // implementation(libs.slf4j.api)
                // implementation(project.dependencies.platform("org.slf4j:slf4j-api:2.0.17"))

                runtimeOnly(project(":renderer"))
                implementation(libs.slf4j.simple)

                // compileOnly("")
            }
        }
    }
}
