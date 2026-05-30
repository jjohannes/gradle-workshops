package org.example.javarca.model

/**
 * An actor is represented by a 'symbol' and has some fundamental [ActorProperty]s. It may provide
 * [ActorCollision]s which essential make up the behavior of a game. If two actors collide on the
 * [Stage], the corresponding collision logic is triggered.
 */
data class Actor(
    val symbol: Char,
    val modifiers: Set<ActorPropertyModifier>,
    val collisionFunctions: Map<Char, ActorCollision>,
)
