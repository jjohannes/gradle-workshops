plugins {
    id("my.java-library") // Convention Plugin
    id("jacoco")
}

val myClasspath = configurations.create("myClasspath")  {
    isCanBeResolved = true
    isCanBeConsumed = true
}

dependencies {
    myClasspath("org.apache.commons:commons-lang3:3.12.0")
    api("org.apache.commons:commons-lang3:3.12.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.0")
}


tasks.register<Zip>("allZip") {
    from(configurations.runtimeClasspath)
    // configurations.runtimeClasspath.get().incoming.resolutionResult
}


/*
configurations {
    val api = create("api") {
        isCanBeResolved = false
        isCanBeConsumed = false
    }
    val implementation = create("implementation") {
        isCanBeResolved = false
        isCanBeConsumed = false
    }
    val runtimeOnly = create("runtimeOnly") {
        isCanBeResolved = false
        isCanBeConsumed = false
    }

    create("runtimeClasspath") {
        isCanBeResolved = true
        isCanBeConsumed = false
        extendsFrom(implementation)
        extendsFrom(api)
        extendsFrom(runtimeOnly)
    }
    create("compileClasspath") {
        isCanBeResolved = true
        isCanBeConsumed = false
        extendsFrom(implementation)
        extendsFrom(api)
    }

    create("runtimeElements") {
        isCanBeResolved = false
        isCanBeConsumed = true
        extendsFrom(implementation)
        extendsFrom(api)
        extendsFrom(runtimeOnly)

        outgoing.artifact(tasks.jar)
    }
    create("apiElements") {
        isCanBeResolved = false
        isCanBeConsumed = true
        extendsFrom(api)
    }
}*/

// configurations.compileClasspath

