package org.example.javarca.model

/**
 * Define the stage in which a Game takes place via symbols representing the [Actor]s to be
 * initially placed in the game. A stage needs to have 16 lines with each line being 16 characters
 * long.
 */
fun interface Stage {
    fun define(): String
}
