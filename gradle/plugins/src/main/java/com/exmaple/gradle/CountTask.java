package com.exmaple.gradle;

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
public abstract class CountTask extends DefaultTask {

    @InputFiles
    @PathSensitive(PathSensitivity.RELATIVE)
    abstract public ConfigurableFileCollection getFilesToCount();

    @Input
    abstract public Property<String> getInfo();

    @OutputFile
    abstract public RegularFileProperty getCountFile();

    public CountTask() {
        // getOutputs().upToDateWhen(t -> false);
    }

    @TaskAction
    public void count() throws IOException {
        String info = getInfo().get();
        File outFile = getCountFile().get().getAsFile();
        Set<File> filesToCount = getFilesToCount().getFiles();

        getLogger().info(info);

        Files.writeString(outFile.toPath(), info + " " + filesToCount.size());
    }

}
