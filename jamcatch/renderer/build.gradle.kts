plugins {
    id("my-kotlin-library")
}

dependencies {
    jvmMainApi(project(":engine"))
    jvmMainImplementation("org.lwjgl:lwjgl-glfw:3.3.6")
    jvmMainImplementation("org.lwjgl:lwjgl-opengl:3.3.6")
    jvmMainImplementation("org.lwjgl:lwjgl-stb:3.3.6")
    jvmMainImplementation("org.lwjgl:lwjgl:3.3.6")
}
