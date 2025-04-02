plugins {
    id("com.example.java-library")
}

dependencies {
    api(libs.commons.lang3)

    implementation("org.bouncycastle:bcprov-jdk15on:1.70")
    //implementation("org.bouncycastle:bcprov-jdk18on:1.71")
    implementation("org.bouncycastle:bcprov-ext-jdk15on:1.70")
}
