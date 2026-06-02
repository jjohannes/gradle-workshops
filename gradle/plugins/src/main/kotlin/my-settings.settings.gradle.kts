pluginManagement {
    repositories {
        gradlePluginPortal()
        // maven("https://my.org/repo") {
        //     credentials {  }
        // }
    }
}

File(rootDir, "jamcatch").listFiles()?.forEach { dir ->
    if (File(dir, "settings.gradle.kts").exists()) {
        // includeBuild(dir)
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        // maven("jamcatch/test-repo")
    }
}