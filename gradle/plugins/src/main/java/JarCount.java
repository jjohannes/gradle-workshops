import org.gradle.api.DefaultTask;
import org.gradle.api.file.ConfigurableFileCollection;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.CacheableTask;
import org.gradle.api.tasks.Classpath;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Set;

@CacheableTask
abstract public class JarCount extends DefaultTask {

    @Input
    abstract public Property<String> getHeader();

    @InputFiles
    @Classpath
    abstract public ConfigurableFileCollection getFilesToCount();

    @OutputFile
    abstract public RegularFileProperty getCountTextFile();

    @TaskAction
    public void count() throws IOException {
        String h = getHeader().get();
        Set<File> jarFiles = getFilesToCount().getFiles();
        File txtFile = getCountTextFile().get().getAsFile();

        String out = h + " " + jarFiles.size() + "\n" +
                jarFiles.stream().map(File::getName).toList();
        System.out.println(out);
        Files.writeString(txtFile.toPath(), out);
    }
}
