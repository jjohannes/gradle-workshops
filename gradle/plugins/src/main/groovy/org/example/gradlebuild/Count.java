package org.example.gradlebuild;

import org.gradle.api.DefaultTask;
import org.gradle.api.file.ConfigurableFileCollection;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Set;

abstract public class Count extends DefaultTask {

    @Input
    abstract Property<String> getText();

    @InputFiles
    abstract ConfigurableFileCollection getFilesToCount();

    @OutputFile
    abstract RegularFileProperty getCountTxtFile();

    @TaskAction
    public void doCount() throws IOException {
        // inputs
        String text = getText().get();
        Set<File> filesToCount = getFilesToCount().getFiles();

        // output
        File out = getCountTxtFile().get().getAsFile();

        // action
        String message = "Counting... " + text + " " + filesToCount.size() +
                "\n" + filesToCount;
        Files.write(out.toPath(), message.getBytes());
    }

}
