plugins {
    id("my-java-library")
}

tasks.test {
    useJUnitPlatform { // JUnit 5
        excludeTags("slow")
    }
}

tasks.register<Test>("testSlow") {
    classpath = sourceSets.test.get().runtimeClasspath
    testClassesDirs = sourceSets.test.get().output

    useJUnitPlatform {
        includeTags("slow")
    }

    maxParallelForks = 4
    maxHeapSize = "2g"
}

testing {
    // suites.named<JvmTestSuite>("test") {
    //     useJUnitJupiter()
    // }
    suites.register<JvmTestSuite>("integrationTest") {
        useJUnitJupiter("5.9.3")
        // dependencies {
        //
        // }
    }
}

dependencies {
    implementation(platform(project(":dependency-versions")))

    implementation(project(":data-model"))
    implementation("org.apache.commons:commons-text")
    implementation("org.slf4j:slf4j-api")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    // "integrationTest"("org.junit.jupiter:junit-jupiter-api:5.9.3")
}