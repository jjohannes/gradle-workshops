package org.example.javarca.model

/**
 * Represents the collision logic between two [Actor]s. A collision function has access to the two
 * colliding [ActorState]s, but may also access and modify the state of any other actor on the
 * stage.
 */
fun interface ActorCollision {
    fun collide(myState: ActorState, otherState: ActorState, allStates: ActorStates)
}
