plugins {
    id("de.db.java-library2") // Convention Plugin
}

dependencies {
    implementation("org.apache.commons:commons-lang3")
    implementation(libs.commonsLang)
    implementation("de.db:data-model") // = implementation(project(":data-model"))
    implementation("com.fasterxml.jackson.core:jackson-core")
    implementation(platform("com.fasterxml.jackson:jackson-bom:2.13.0"))
}

tasks.myTask {
    mail.set("zzzz")
}

