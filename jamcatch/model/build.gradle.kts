plugins {
    id("my-java-library")
}



// tasks.test {
//     useJUnitPlatform()
// }

testing {
    suites {
        named<JvmTestSuite>("test") {
            useJUnitJupiter()
        }
        register<JvmTestSuite>("xtest")
    }
}

tasks.test {
    maxParallelForks = 100
    maxHeapSize = "2g"
}