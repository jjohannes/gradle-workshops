plugins {
    id("java-library")
    id("org.gradlex.jvm-dependency-conflict-resolution") version "2.5"
}


java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

dependencies  {
    implementation(project(":model"))
    implementation(project(":engine"))

    implementation("org.lwjgl:lwjgl:3.3.6")
    implementation("org.lwjgl:lwjgl-glfw")
    implementation("org.lwjgl:lwjgl-opengl")
    implementation("org.lwjgl:lwjgl-stb")
}
