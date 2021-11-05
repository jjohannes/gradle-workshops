package de.db

import org.gradle.api.DefaultTask
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.*
import org.gradle.workers.WorkerExecutor
import javax.inject.Inject

@CacheableTask
abstract class MyTask : DefaultTask() {

    @get:InputFiles
    @get:PathSensitive(PathSensitivity.NAME_ONLY)
    abstract val classFile: ConfigurableFileCollection

    @get:Input
    abstract val mail: Property<String>

    @get:OutputFile
    abstract val tokenFile: RegularFileProperty

    @get:Inject
    abstract val worker: WorkerExecutor // <-- Inject a Gradle service

    @Internal
    fun getMailPlain(): String {
        return mail.get()
    }

    @TaskAction
    fun generate() {
        tokenFile.get().asFile.writeText("m:" + mail.get() + classFile.files)
    }


}