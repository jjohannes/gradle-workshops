plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("org.gradlex.jvm-dependency-conflict-resolution")
    id("com.diffplug.spotless")
    id("com.autonomousapps.dependency-analysis")
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

// configure code formatting
spotless {
    kotlin {
        ktfmt().kotlinlangStyle()
        target("src/*/kotlin/**/*.kt")
    }
}
