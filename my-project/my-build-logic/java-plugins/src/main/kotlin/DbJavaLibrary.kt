import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaLibraryPlugin
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.gradle.kotlin.dsl.getByType

// Convention Plugin as Class
class DbJavaLibrary : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            plugins.apply(JavaLibraryPlugin::class.java)
            val java = project.extensions.getByType<JavaPluginExtension>()
            java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

            // extensions.create<DbExtension>("dbExtension")
        }

    }

}