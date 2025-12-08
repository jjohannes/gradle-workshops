plugins {
    id("my-java-library")
    id("feature-spring-boot")
}

dependencies  {
    implementation(project(":model"))
    implementation(project(":engine"))

    implementation("org.lwjgl:lwjgl:3.3.6")
    implementation("org.lwjgl:lwjgl-glfw")
    implementation("org.lwjgl:lwjgl-opengl")
    implementation("org.lwjgl:lwjgl-stb")
}
