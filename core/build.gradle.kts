plugins {
    id("java-library")
    id("maven-publish")
}

group = "org.example"
version = "1.0"

dependencies {
    api(platform(project(":platform")))

    implementation("org.apache.commons:commons-text")
}


val codeGeneration = tasks.register<MyTask>("codeGeneration") {
    originalSource.set(layout.projectDirectory.dir("xyz"))
    generatedSource.set(layout.buildDirectory.dir("internal-files"))
}
val internalJar = tasks.register<Jar>("internalJar") {
    from(codeGeneration.flatMap { task -> task.generatedSource })
    archiveClassifier = "internal"
}

// https://docs.gradle.org/current/userguide/publishing_customization.html#sec:adding-variants-to-existing-components
// Adjust existing variant 'runtimeElements'
configurations.runtimeElements {
    outgoing.artifacts.clear() // remove 'tasks.jar' as artifact
    outgoing.artifact(internalJar)
}

// Add a new variant 'metaElements'
val metaElements = configurations.create("metaElements") { // configurations.consumable(...) since Gradle 8.4
    isCanBeConsumed = true
    isCanBeResolved = false

    // extendsFrom(configurations.implementation.get())
    outgoing.artifact(internalJar)

    attributes {
        attribute(Usage.USAGE_ATTRIBUTE, objects.named("meta"))
    }
}

dependencies {
    metaElements("commons-codec:commons-codec:1.16.0")
}

// Make 'metaElements' a published 'outgoing variant'
(components["java"] as AdhocComponentWithVariants).addVariantsFromConfiguration(metaElements) {}

publishing {
    publications.create<MavenPublication>("maven") {
        // artifact(tasks.jar)
        // artifact(internalJar)
        from(components["java"])
        // versionMapping {
        //     allVariants {
        //         fromResolutionResult()
        //     }
        // }
    }
}

publishing {
    repositories {
        maven("../test-repo")
    }
}


abstract class MyTask : DefaultTask() {

    @get:InputDirectory
    abstract val originalSource : DirectoryProperty

    @get:OutputDirectory
    abstract val generatedSource: DirectoryProperty

    @TaskAction
    fun gen() {
        generatedSource.file("gen.txt").get().asFile.writeText("...")
    }
}