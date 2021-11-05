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



val libs = extensions.getByType<Libs>()
dependencies.constraints {
    implementation("${libs.commonsLang}:3.11")
}

