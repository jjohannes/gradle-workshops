plugins {
    id("my-kmp-library")
}

dependencies {
    commonMainApi(project(":engine"))
    commonMainImplementation("org.lwjgl:lwjgl-glfw:3.3.6")
    commonMainImplementation("org.lwjgl:lwjgl-opengl:3.3.6")
    commonMainImplementation("org.lwjgl:lwjgl-stb:3.3.6")
    commonMainImplementation("org.lwjgl:lwjgl:3.3.6")
}
