import org.gradle.api.DefaultTask;
import org.gradle.api.file.ConfigurableFileCollection;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.CacheableTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.PathSensitive;
import org.gradle.api.tasks.PathSensitivity;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Set;

@CacheableTask
abstract public class JarCount extends DefaultTask {

    @InputFiles
    @PathSensitive(PathSensitivity.RELATIVE)
    public abstract ConfigurableFileCollection getJars();

    @Input
    public abstract Property<String> getInfo();

    @OutputFile
    public abstract RegularFileProperty getCountOutputFile();

    @TaskAction
    public void count() throws IOException {
        Set<File> files = getJars().getFiles();
        String info = getInfo().get();
        File outputFile = getCountOutputFile().get().getAsFile();

        Files.writeString(outputFile.toPath(), info +
                "Files counted: " + files.size());
    }
}
