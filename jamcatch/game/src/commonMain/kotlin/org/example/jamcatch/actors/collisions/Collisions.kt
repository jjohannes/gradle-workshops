package org.example.jamcatch.actors.collisions

import java.util.*
import org.example.javarca.model.ActorCollision
import org.example.javarca.model.ActorProperty
import org.example.javarca.model.ActorState
import org.example.javarca.model.ActorStates
import org.example.javarca.model.GameConstants.PRECISION
import org.example.javarca.model.GameConstants.SYMBOL_EMPTY_SPOT

interface Collisions {
    companion object {
        val DEMO_MODE: String? = System.getenv("DEMO_MODE")

        val p =
            mapOf(
                'J' to
                    ActorCollision {
                        myState: ActorState,
                        otherState: ActorState,
                        allStates: ActorStates ->
                        otherState.destroy()
                        myState.addToValue(
                            ActorProperty.POINTS,
                            otherState.getValue(ActorProperty.POINTS),
                        )
                        allStates.filter('0').print(myState.getValue(ActorProperty.POINTS))
                        var skin = 'H'
                        skin += Random().nextInt(5).toChar().code
                        val newJar = allStates.spawn('J', Random().nextInt(14) + 1, 0, skin)
                        newJar.setValue(
                            ActorProperty.SPEEDY,
                            otherState.getValue(ActorProperty.SPEEDY) + 100,
                        )
                    },
                SYMBOL_EMPTY_SPOT to
                    ActorCollision {
                        myState: ActorState,
                        otherState: ActorState,
                        allStates: ActorStates ->
                        allStates.filter(':').setSkin(SYMBOL_EMPTY_SPOT) // make text row invisible
                        val target =
                            allStates
                                .filter('J')
                                .filter(ActorProperty.SPEEDY) { v: Int? -> v!! > 0 }
                                .maxX()
                        if (DEMO_MODE != null) {
                            if (myState.x() > target) {
                                myState.setX(myState.x() - 1500)
                            } else if (myState.x() < target) {
                                myState.setX(myState.x() + 1500)
                            }
                        }
                    },
            )
        val j =
            mapOf<Char, ActorCollision>(
                'J' to
                    ActorCollision {
                        myState: ActorState?,
                        otherState: ActorState?,
                        allStates: ActorStates? ->
                        myState!!.setValue(ActorProperty.SPEEDY, 0)
                        val player = allStates!!.filter('p')
                        player.setY(
                            allStates
                                .filter('J')
                                .filter(ActorProperty.SPEEDY) { v: Int? -> v == 0 }
                                .minY() - PRECISION
                        )
                        if (player.minY() <= PRECISION * 2) {
                            player.destroy()
                            allStates.filter(':').print("GAME.OVER")
                        } else {
                            allStates.spawn('J', Random().nextInt(14) + 1, 0)
                        }
                    },
                'X' to
                    ActorCollision {
                        myState: ActorState?,
                        otherState: ActorState?,
                        allStates: ActorStates? ->
                        myState!!.setValue(ActorProperty.SPEEDY, 0)
                        allStates!!.spawn('J', Random().nextInt(14) + 1, 0)
                        allStates
                            .filter('p')
                            .setY(
                                allStates
                                    .filter('J')
                                    .filter(ActorProperty.SPEEDY) { v: Int? -> v == 0 }
                                    .minY() - PRECISION
                            )
                    },
            )

        val ALL = mapOf('p' to p, 'J' to j)
    }
}
