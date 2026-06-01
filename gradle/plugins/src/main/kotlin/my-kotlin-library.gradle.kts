plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("org.gradlex.jvm-dependency-conflict-resolution")
}

kotlin {
    jvm()
    js { browser() }
}

configurations {
    named("jvmRuntimeClasspath") {
        attributes.attribute(
            OperatingSystemFamily.OPERATING_SYSTEM_ATTRIBUTE, objects.named(OperatingSystemFamily.MACOS)
        )
        attributes.attribute(
            MachineArchitecture.ARCHITECTURE_ATTRIBUTE, objects.named(MachineArchitecture.ARM64)
        )
    }
    named("jsNpmAggregated") {
        attributes.attribute(
            OperatingSystemFamily.OPERATING_SYSTEM_ATTRIBUTE, objects.named(OperatingSystemFamily.MACOS)
        )
        attributes.attribute(
            MachineArchitecture.ARCHITECTURE_ATTRIBUTE, objects.named(MachineArchitecture.ARM64)
        )
    }
}
