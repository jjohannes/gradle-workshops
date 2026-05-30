package org.example.javarca.model

/**
 * Represents the state of a set of [Actor]s on the [Stage] of a running game. This allows for
 * matching and modifying a set of [ActorState]s in a [ActorCollision] function.
 */
interface ActorStates {
    /** A subset of characters in this set that are represented by the given 'symbol'. */
    fun filter(symbol: Char): ActorStates

    /**
     * A subset of characters in this set that have the given property matches the give predicate.
     */
    fun filter(p: ActorProperty, value: (Int) -> Boolean): ActorStates

    /** Set the horizontal position of all actors in this set. */
    fun setX(x: Int): Int

    /** Set the vertical position of all actors in this set. */
    fun setY(y: Int): Int

    /** Vertical position of the actor that is the closest to the top. */
    fun minY(): Int

    /** Vertical position of the actor that is the closest to the bottom. */
    fun maxY(): Int

    /** Horizontal position of the actor that is the farthest left. */
    fun minX(): Int

    /** Horizontal position of the actor that is the farthest right. */
    fun maxX(): Int

    /** Skin this set of actors with character assets that show a text/number on the stage. */
    fun print(value: String)

    /** Skin this set of actors with character assets that show a text/number on the stage. */
    fun print(value: Int)

    /** Change the skin of all actors in the set. */
    fun setSkin(c: Char)

    /** Destroy all actors in this set. */
    fun destroy()

    /** Spawn a new actor on the stage. */
    fun spawn(symbol: Char, x: Int, y: Int): ActorState

    /** Spawn a new actor on the stage. */
    fun spawn(symbol: Char, x: Int, y: Int, skin: Char): ActorState
}
