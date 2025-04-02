plugins {
    id("com.example.java-library")
}

dependencies {
    api(project(":data"))
    implementation(libs.commons.text)
    implementation(libs.slf4j.api)
}

// implementation
// api
// runtimeOnly
// compileOnly (compileOnlyApi)