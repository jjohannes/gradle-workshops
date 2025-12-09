plugins {
    id("my-java-library")
}

dependencies  {
    // implementation(project(":model"))
    api(project(":engine"))

    implementation("org.lwjgl:lwjgl")
    implementation("org.lwjgl:lwjgl-glfw")
    implementation("org.lwjgl:lwjgl-opengl")
    implementation("org.lwjgl:lwjgl-stb")
}



/*
configurations.api {

}
configurations.runtimeClasspath {
}

val myScope = configurations.dependencyScope("myScope")

val myOwnClasspath=  configurations.resolvable("myOwnClasspath") {
    extendsFrom(myScope.get())
}

dependencies {
    myScope(project(":engine"))
}
*/
