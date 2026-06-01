plugins {
    id("org.jetbrains.kotlin.multiplatform") version "2.3.21"
}

kotlin {
    jvm()
    js { browser() }
}
