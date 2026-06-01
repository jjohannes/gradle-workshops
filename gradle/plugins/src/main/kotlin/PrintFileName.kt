import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction

abstract class PrintFileName : DefaultTask() {

    @get:InputFile
    @get:PathSensitive(PathSensitivity.RELATIVE)
    abstract val fileToPrint : RegularFileProperty

    @TaskAction
    fun printSomething() {
        val file = fileToPrint.get().asFile
        println("File name: ${file.name}")
    }

}
