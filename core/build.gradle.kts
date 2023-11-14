plugins {
    id("java-library")
    id("maven-publish")
}

group = "org.example"
version = "1.0"

val meta = configurations.create("meta")

dependencies {
    api(platform(project(":platform")))

    implementation("org.apache.commons:commons-text")

    meta(platform("org.example:platform:1.0"))
    meta("org.apache.commons:commons-text")
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

val codeGeneration = tasks.register<MyTask>("codeGeneration") {
    originalSource.set(layout.projectDirectory.dir("xyz"))
    generatedSource.set(layout.buildDirectory.dir("internal-files"))
}

val internalJar = tasks.register<Jar>("internalJar") {
    from(codeGeneration.flatMap { task -> task.generatedSource })
    archiveClassifier = "internal"
}

configurations.runtimeElements {
    outgoing.artifacts.clear()
    outgoing.artifact(internalJar)
}
configurations.apiElements {
    outgoing.artifacts.clear()
    outgoing.artifact(internalJar)
}

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