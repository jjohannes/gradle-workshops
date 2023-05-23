plugins {
    id("my.base")
    id("java-library")
    id("maven-publish")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    manifest {
        attributes("Manifest-Version" to project.version)
    }
    this.archiveVersion.set("")
}

tasks.publish {
    if (providers.exec {
        commandLine("git", "diff")
    }.standardOutput.asText.get().trim().isNotBlank()) {
        throw RuntimeException("publishing without commit")
    }
}

publishing {
    repositories.maven("../test-repo")
    publications {
        create<MavenPublication>("library") {
            from(components["java"])
            versionMapping {
                usage("java-api") {
                    // fromResolutionOf("runtimeClasspath")
                    fromResolutionResult()
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }
        }
    }
}

