plugins {
    id("java")
    id("org.gradlex.jvm-dependency-conflict-resolution")
}

jvmDependencyConflicts {
    patch {
        module("org.apache.commons:commons-text") {
            reduceToRuntimeOnlyDependency("org.apache.commons:commons-lang3")
        }
    }
    conflictResolution {
        select("org.gradlex:bouncycastle-bcprov", "org.bouncycastle:bcprov-ext-jdk15on")
    }
}


java {
    toolchain.languageVersion = JavaLanguageVersion.of(17)
}

tasks.withType<JavaCompile>().configureEach {
    options.forkOptions.memoryMaximumSize = "2g"
}

tasks.test {
    maxHeapSize = "1g"
}

// Lifecycle task
tasks.assemble {
    dependsOn(tasks.compileTestJava)
}