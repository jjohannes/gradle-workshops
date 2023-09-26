plugins {
    id("java")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}



// OLD, do not use:
// tasks.getByName("compileJava", JavaCompile::class) {
//     options.encoding = "UTF-8"
// }

tasks.named("compileJava", JavaCompile::class) {
    options.encoding = "UTF-8"
}
tasks.compileJava {
    group = "my group"
    description = "bla bla"
    options.encoding = "UTF-8"
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}


