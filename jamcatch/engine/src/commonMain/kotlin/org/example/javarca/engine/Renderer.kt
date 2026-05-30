package org.example.javarca.engine

import java.util.*
import java.util.function.Consumer

/**
 * Interface to be implemented on top of a library or framework that renders a running game. The
 * implementation should use [GameLoop] and [GameState],
 */
interface Renderer {
    fun run()

    companion object {
        fun launch() {
            println("Welcome to Javarcade!")

            Thread.setDefaultUncaughtExceptionHandler { thread: Thread, throwable: Throwable ->
                println("Unexpected crash!" + throwable.message)
                throwable.printStackTrace()
                throw RuntimeException(throwable)
            }

            val impl = ServiceLoader.load(Renderer::class.java).findFirst()
            impl.ifPresentOrElse(Consumer { obj: Renderer? -> obj!!.run() }) {
                println("No renderer implementation available")
            }
        }
    }
}
