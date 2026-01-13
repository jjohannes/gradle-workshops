plugins {
    id("my-java-library")
}

dependencies {
    implementation(project(":model"))
    implementation(project(":engine"))
    implementation("org.lwjgl:lwjgl-glfw:3.3.6")
    implementation("org.lwjgl:lwjgl-opengl:3.3.6")
    implementation("org.lwjgl:lwjgl-stb:3.3.6")
    implementation("org.lwjgl:lwjgl:3.3.6")
}
