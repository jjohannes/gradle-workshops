plugins {
    //id("java-gradle-plugin")
    `kotlin-dsl`
}

gradlePlugin {
    plugins.create("de.db.java-library") {
        implementationClass = "DbJavaLibrary"
        id = "de.db.java-library"
    }
}