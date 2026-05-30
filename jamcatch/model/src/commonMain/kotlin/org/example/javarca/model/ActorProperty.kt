package org.example.javarca.model

/**
 * Pre-defined properties each [Actor] can have. They decide if and how an [Actor] moves on the
 * [Stage] and if [Actor]s can collide to trigger [ActorCollision] logic.
 */
enum class ActorProperty {
    PLAYER,
    SPEEDX,
    SPEEDY,
    BLOCKING,
    DESTRUCTIBLE,
    POINTS,
}
