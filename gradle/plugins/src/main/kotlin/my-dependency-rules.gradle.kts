plugins {
    id("java")
    id("org.gradlex.jvm-dependency-conflict-resolution")
    id("io.mvnpm.gradle.plugin.native-java-plugin")
    id("com.autonomousapps.dependency-analysis")
}

dependencies {
    implementation(platform(project(":versions")))
}

jvmDependencyConflicts {
    consistentResolution {
        providesVersions(":game")
    }

    conflictResolution {
        select("org.gradlex:slf4j-impl", "org.slf4j:slf4j-simple")
    }

    patch {
        module("com.google.guava:guava") {
            // remove annotation libraries we do not need
            removeDependency("com.google.j2objc:j2objc-annotations")
            removeDependency("org.checkerframework:checker-qual")
        }
    }
}

// configurations.runtimeClasspath {
//     attributes {
//         attribute(OperatingSystemFamily.OPERATING_SYSTEM_ATTRIBUTE, objects.named(OperatingSystemFamily.WINDOWS))
//         attribute(MachineArchitecture.ARCHITECTURE_ATTRIBUTE, objects.named(MachineArchitecture.X86_64))
//     }
// }
// configurations.compileClasspath {
//     shouldResolveConsistentlyWith(configurations.runtimeClasspath.get())
// }