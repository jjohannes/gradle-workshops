plugins {
    id("com.example.java-library")
}

dependencies {
    implementation(project(":data"))
}

tasks.compileJava {
    // classpath = files()
}