plugins {
    id("java")
    id("org.gradlex.jvm-dependency-conflict-resolution")
    id("io.mvnpm.gradle.plugin.native-java-plugin")
    id("com.autonomousapps.dependency-analysis")
}

// configurations.runtimeClasspath {
//     attributes {
//         attribute(OperatingSystemFamily.OPERATING_SYSTEM_ATTRIBUTE, objects.named(OperatingSystemFamily.WINDOWS))
//         attribute(MachineArchitecture.ARCHITECTURE_ATTRIBUTE, objects.named(MachineArchitecture.X86_64))
//     }
// }
