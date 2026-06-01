plugins {
    id("my-kotlin-library")
}

kotlin {
    jvm { mainRun { mainClass = "org.example.jamcatch.game.GameAppKt" } }
}
