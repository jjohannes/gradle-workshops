import org.gradle.api.DefaultTask
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

abstract class JarCount extends DefaultTask {

    @InputFiles
    abstract ConfigurableFileCollection getJarFiles()

    @OutputFile
    abstract RegularFileProperty getCountFile()

    @TaskAction
    void count() {
        def text = "${getJarFiles().files.size()} / ${getJarFiles().files.collect { '\n' + it.name }}"
        println(text)
        getCountFile().get().asFile.write(text)
    }
}
