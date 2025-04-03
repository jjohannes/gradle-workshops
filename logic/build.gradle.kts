plugins {
    id("com.example.java-library")
}

// sourceSets.create("xzt")

testing.suites.named<JvmTestSuite>("test") {
    useJUnitJupiter()
}

testing.suites.register<JvmTestSuite>("integTest") {
    targets.configureEach {
        testTask {
            useJUnitPlatform {
                // excludeTags("slow")
            }
            maxHeapSize = "2g"
            systemProperty("INTEG", "TRUE")

            maxParallelForks = 4
            // exclude("**/*Slow.class")
        }
    }
}

dependencies {
    api(project(":data"))
    implementation(libs.commons.text)
    implementation(libs.slf4j.api)

    "integTestImplementation"(project)

    // testImplementation("org.junit.jupiter:junit-jupiter-api:5.12.1")
    //
    // testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    // testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}



// implementation
// api
// runtimeOnly
// compileOnly (compileOnlyApi)