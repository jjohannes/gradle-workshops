plugins {
    id("com.example.java-library")
}

dependencies {
    // implementation
    // api
    // runtimeOnly
    // compileOnly (compileOnlyApi)
    api(project(":data"))
}
