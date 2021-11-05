plugins {
    id("de.db.java-library2") // Convention Plugin
    id("maven-publish")
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
            url = uri("test-repo")
        }
        create<MavenPublication>("something") {
            from(components["java"])
        }
    }
}




