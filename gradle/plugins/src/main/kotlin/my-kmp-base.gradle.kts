plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("org.gradlex.jvm-dependency-conflict-resolution")
    id("com.diffplug.spotless")
    id("com.autonomousapps.dependency-analysis")
}

kotlin {
    jvm()
    // androidTarget()
}

// configure code formatting
spotless {
    kotlin {
        ktfmt().kotlinlangStyle()
        target("src/*/kotlin/**/*.kt")
    }
}
