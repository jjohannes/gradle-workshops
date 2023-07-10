package org.example;

import org.gradle.api.DefaultTask;
import org.gradle.api.file.ConfigurableFileCollection;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.CacheableTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Set;

// @CacheableTask
abstract public class JarCount extends DefaultTask {

    @Input
    public abstract Property<String> getExtraText();

    @InputFiles
    public abstract ConfigurableFileCollection getJars();

    @OutputFile
    public abstract RegularFileProperty getCountFile();

    @TaskAction
    public void count() throws IOException {
        Set<File> allJars = getJars().getFiles();
        File outFile = getCountFile().get().getAsFile();

        String result = getExtraText().get() + ": " + allJars.size();

        System.out.println(result);

        Files.write(outFile.toPath(), result.getBytes());
    }
}
