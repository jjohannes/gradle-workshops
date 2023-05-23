
// val suffix = "-" + project.providers.gradleProperty("timestamp").orElse("")
val timestampFromGit = providers.exec {
    commandLine("git", "log", "-1", "--format=%cd", "--date=format-local:'%Y%m%d%H%M%S'")
}.standardOutput.asText.get().trim()

allprojects {
    version = "1.0-$timestampFromGit"
}
