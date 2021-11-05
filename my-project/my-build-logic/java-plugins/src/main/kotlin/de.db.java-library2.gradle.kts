import de.db.Libs

plugins {
    id("de.db.base")
    id("java-library")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks.test {

}

dependencies.constraints {
    implementation("org.apache.commons:commons-lang3:3.11")
}
