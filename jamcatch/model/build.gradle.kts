plugins {
    id("my-java-library")
}



// tasks.test {
//     useJUnitPlatform()
// }

sourceSets {
    main {
        // java.srcDir(tasks.named("codeGen"))
    }
}

// sourceSets.register("mynew")

tasks.compileJava {
    // dependsOn(tasks.named("codeGen"))
}

java {

}

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