package org.example.javarca.model

/** Represents the state of an [Actor] on the [Stage] of a running game. */
interface ActorState {
    /** Destroy this actor. */
    fun destroy()

    /**
     * Is the actor still alive? Actors that have been destroyed are no longer alive and considered
     * during collision computation.
     */
    fun isAlive(): Boolean

    /** Horizontal position of the actor on the stage. */
    fun x(): Int

    /** Set the horizontal position of the actor on the stage. */
    fun setX(x: Int): Int

    /** Vertical position of the actor on the stage. */
    fun y(): Int

    /** Set the vertical position of the actor on the stage. */
    fun setY(y: Int): Int

    /** Current value of the given [ActorProperty]. */
    fun getValue(p: ActorProperty): Int

    /** Reset the given [ActorProperty] to its original value. */
    fun resetValue(p: ActorProperty): Int

    /** Set the given [ActorProperty] to the given value. */
    fun setValue(p: ActorProperty, value: Int): Int

    /**
     * Increase the given [ActorProperty] by the given increment. A negative increment may be used
     * to decrease the value.
     */
    fun addToValue(p: ActorProperty, increment: Int): Int

    /** Multiply the given [ActorProperty] by the given multiplier. */
    fun multiplyValue(p: ActorProperty, multiplier: Int): Int

    /**
     * Change the 'skin' character of the actor. While the actor is always referred to by its given
     * symbol in game logic (which cannot be changed) the skin gives the actor another appearance by
     * the [Asset] linked to the skin character.
     */
    fun setSkin(skin: Char): Char
}
