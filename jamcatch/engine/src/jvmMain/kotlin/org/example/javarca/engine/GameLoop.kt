package org.example.javarca.engine

import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit
import org.example.javarca.model.ActorProperty
import org.example.javarca.model.GameConstants

/**
 * The main game loop that calls the update methods on each [Spot] in the active game in a regular
 * interval.
 */
class GameLoop {
    private lateinit var exec: ScheduledExecutorService
    private lateinit var gameState: GameState

    fun start(gameState: GameState) {
        this.gameState = gameState
        exec = Executors.newSingleThreadScheduledExecutor()
        exec.scheduleAtFixedRate({ updateWithErrorLog() }, 0, 20, TimeUnit.MILLISECONDS)
    }

    private fun updateWithErrorLog() {
        try {
            update()
        } catch (e: Exception) {
            e.printStackTrace()
            throw RuntimeException("Unexpected error in game loop", e)
        }
    }

    private fun update() {
        for (spot in gameState.spots.toList()) {
            // translate keypress into speed
            if (spot.isAlive() && spot.getValue(ActorProperty.PLAYER) == GameConstants.TRUE) {
                when {
                    gameState.isUp -> {
                        spot.resetValue(ActorProperty.SPEEDY)
                        spot.multiplyValue(ActorProperty.SPEEDY, -1)
                    }
                    gameState.isDown -> {
                        spot.resetValue(ActorProperty.SPEEDY)
                    }
                    else -> {
                        spot.setValue(ActorProperty.SPEEDY, 0)
                    }
                }

                when {
                    gameState.isLeft -> {
                        spot.resetValue(ActorProperty.SPEEDX)
                        spot.multiplyValue(ActorProperty.SPEEDX, -1)
                    }
                    gameState.isRight -> {
                        spot.resetValue(ActorProperty.SPEEDX)
                    }
                    else -> {
                        spot.setValue(ActorProperty.SPEEDX, 0)
                    }
                }
            }
            if (spot.isAlive()) {
                spot.move(
                    spot.getValue(ActorProperty.SPEEDX),
                    spot.getValue(ActorProperty.SPEEDY),
                    gameState.spots,
                    gameState.all,
                )
            }
        }
    }

    fun stop() {
        exec.shutdown()
    }
}
