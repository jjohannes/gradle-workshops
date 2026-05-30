plugins {
    id("my-kmp-base")
}

configurations.named("jvmRuntimeClasspath") {
    attributes.attribute(
        OperatingSystemFamily.OPERATING_SYSTEM_ATTRIBUTE, objects.named(OperatingSystemFamily.MACOS));
    attributes.attribute(
        MachineArchitecture.ARCHITECTURE_ATTRIBUTE, objects.named(MachineArchitecture.ARM64));
}
