plugins {
    id("de.db.base")
    id("java-library")
    id("maven-publish")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks.test {

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


