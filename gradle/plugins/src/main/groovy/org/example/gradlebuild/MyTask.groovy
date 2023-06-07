package org.example.gradlebuild

import org.gradle.api.DefaultTask
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction

@CacheableTask
abstract class MyTask extends DefaultTask {
    @Input
    abstract Property<Boolean> getVerbose()

    @InputFiles
    @PathSensitive(PathSensitivity.NAME_ONLY)
    abstract ConfigurableFileCollection getInputFiles()

    @OutputFile
    abstract RegularFileProperty getCountFile()

    @TaskAction
    void doWork() {
        def count = getInputFiles().getFiles().size()

        getCountFile().get().asFile.text = "$count"
    }
}
