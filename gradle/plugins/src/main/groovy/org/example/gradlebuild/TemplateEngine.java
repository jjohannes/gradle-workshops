package org.example.gradlebuild;

import org.gradle.api.DefaultTask;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.InputFile;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Properties;

public abstract class TemplateEngine extends DefaultTask {

    @InputFile
    public abstract RegularFileProperty getTemplate();

    @InputFile
    public abstract RegularFileProperty getData();

    @OutputFile
    public abstract RegularFileProperty getJavaSourceFile();

    @TaskAction
    public void processTemplate() throws IOException {
        File template = getTemplate().get().getAsFile();
        File propertiesFile = getData().get().getAsFile();

        String content = Files.readString(template.toPath(), StandardCharsets.UTF_8);
        Properties data = new Properties();
        data.load(new FileInputStream(propertiesFile));
        String javaCode = content.replace("$message", data.get("message").toString());

        Files.write(getJavaSourceFile().get().getAsFile().toPath(), javaCode.getBytes());
    }
}
