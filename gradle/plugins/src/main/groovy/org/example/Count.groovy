package org.example

import groovy.transform.CompileStatic
import org.gradle.api.DefaultTask
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

// @CacheableTask
@CompileStatic
abstract class Count extends DefaultTask {

    @InputFiles
    abstract ConfigurableFileCollection getJars()

    @Input
    abstract Property<String> getVersion()

    @OutputFile
    abstract RegularFileProperty getCountFile()

    @TaskAction
    def print() {
        countFile.get().asFile.text =
                "Jars ($version): ${getJars().files.collect { it.name }}"
    }

}
