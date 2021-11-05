import de.db.MyTask

plugins {
    id("de.db.base")
    id("java-library")
    id("maven-publish")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

val myTask = tasks.register<MyTask>("myTask") {
    group = "my group"

    mail.set("abc")
    classFile.from(tasks.compileJava)
    tokenFile.set(layout.buildDirectory.file("token.txt"))
}

tasks.jar {
    from(myTask)
}


// React to plugin application
plugins.withId("my-version-plugin") {
    val parseVersion = tasks.named("parseVersion")
    myTask {
        tasks.register<MyTask>("myTask2") {
            group = "my group"

            mail.set(provider { "ddd" })
            classFile.from(parseVersion)
            tokenFile.set(layout.buildDirectory.file("token.txt"))
        }
    }
}

/*
tasks.named() // Neu und Lazy
tasks.getByName() // Alt und Eager
*/

// Hooks:
configurations.implementation.get().withDependencies {
    // directly before dependency resolution
}
plugins.withId("some-id") {
    // after plugins was applied
}
gradle.taskGraph.whenReady {
    // after task graph has been calculated
}

tasks.test {
    useJUnitPlatform()
}

dependencies.constraints {
    api("org.apache.commons:commons-lang3:3.11") {
        version {
            //strictly("[3,4)")
            //prefer("3.11")
            //rejectAll()
        }
    }
}

val java8Runtime = configurations.create("java8Runtime") {
    isCanBeConsumed = true
    isCanBeResolved = false
    extendsFrom(configurations.runtimeElements.get())
    attributes {
        attribute(Usage.USAGE_ATTRIBUTE, objects.named("java-api-8"))
    }
    outgoing.artifacts.clear()
    outgoing.artifact(tasks.jar)
}

val java = components["java"] as AdhocComponentWithVariants
java.addVariantsFromConfiguration(java8Runtime) { }

publishing {
    publications {
        repositories.maven {
            url = uri(rootProject.layout.projectDirectory.dir("test-repo"))
        }
        create<MavenPublication>("something") {
            from(components["java"])
        }
    }
}

