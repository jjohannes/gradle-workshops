import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.JavaPluginExtension;
import org.gradle.api.tasks.compile.JavaCompile;
import org.gradle.jvm.toolchain.JavaLanguageVersion;

public class MyJavaLibrary implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.getPlugins().apply("java-library");

        JavaPluginExtension java = project.getExtensions().getByType(JavaPluginExtension.class);

        java.getToolchain().getLanguageVersion().set(JavaLanguageVersion.of(21));

        project.getTasks().named("compileJava", JavaCompile.class, t -> {
            t.getOptions().setEncoding("UTF-8");
        });
    }
}
