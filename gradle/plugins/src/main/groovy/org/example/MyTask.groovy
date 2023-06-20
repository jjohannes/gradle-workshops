package org.example

import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

abstract class MyTask extends DefaultTask {

    @InputFile
    abstract RegularFileProperty getInfoInput();

    @OutputFile
    abstract RegularFileProperty getOutputInfoText();

    @TaskAction
    void doSomething() {
        getOutputInfoText().get().asFile.text = getInfoInput().get().asFile.text + "!!!"
    }
}
