plugins {
    id("java-platform")
}

// dependencies.constraints {
//     api("org.apache.commons:commons-csv:1.14.1")
//     api("commons-io:commons-io:2.21.0")
//     api("org.slf4j:slf4j-api:2.0.17")
//     api("org.lwjgl:lwjgl:3.3.6")
// }

// Allow upgrading (transitive) versions via catalog by adding constraints
dependencies.constraints {
    val libs = versionCatalogs.named("libs")
    val catalogEntries = libs.libraryAliases.map { libs.findLibrary(it).get().get() }
    catalogEntries.forEach { entry ->
        val version = entry.version
        if (version != null) {
            api(entry) { version { require(version) } }
        }
    }
}
