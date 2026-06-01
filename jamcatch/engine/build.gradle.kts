plugins {
    id("my-kotlin-library")
}

dependencies {
    commonMainApi(project(":model"))
}
