plugins {
    id("my.java-library") // Convention Plugin
}

dependencies {
    implementation(project(":data-model"))

    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("com.fasterxml.jackson.core:jackson-core")

    implementation(platform(project(":platform")))

    implementation(platform("com.fasterxml.jackson:jackson-bom:2.13.0"))
}


