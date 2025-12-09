plugins {
    id("my-java-application")
    // alias(libs.plugins.dep.resolve)
}

dependencies {
    implementation(project(":model"))
    implementation(project(":engine"))
    // implementation("org.apache.commons:commons-csv")
    implementation(libs.commons.csv)
    implementation("org.slf4j:slf4j-api")

    runtimeOnly(project(":renderer"))
    runtimeOnly("org.slf4j:slf4j-simple")

    testImplementation(testFixtures("org.example:engine"))

    // runtimeOnly("org.slf4j:slf4j-jdk14")
    // implementation("org.slf4j:slf4j-api:2.16.1!!") <-- strict version
    // implementation("org.slf4j:slf4j-api") {
    //     version {
    //         strictly("2.16.1")
    //     }
    // }
}

application {
    mainClass = "org.example.jamcatch.game.GameApp"
}