package org.example.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.*

@CacheableTask
abstract class CountFiles : DefaultTask() {

    // @get:InputFiles
    @get:Classpath
    @get:PathSensitive(PathSensitivity.NONE)
    abstract val filesToCount : ConfigurableFileCollection

    @get:OutputFile
    abstract val countFile: RegularFileProperty

    // Java notation:
    // @InputFiles
    // public abstract ConfigurableFileCollection getFilesToCount();

    @TaskAction
    fun count() {
        println("running...")
        val numberOfFiles = filesToCount.files.size
        countFile.get().asFile.writeText(numberOfFiles.toString())
    }

}