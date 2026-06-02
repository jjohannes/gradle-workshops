package org.example.javarca.engine

import java.util.*
import java.util.stream.Collectors
import org.example.javarca.engine.impl.ActorStatesImpl
import org.example.javarca.model.*
import org.example.javarca.model.GameConstants.STAGE_SIZE
import org.example.javarca.model.GameConstants.SYMBOL_EMPTY_SPOT
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Represents the state of the currently running game. The state is primarily composed of a number
 * of [Spot]s, initialized through a [Stage], that may change their state over time.
 */
class GameState {
    val emptyDefault: Stage = Stage {
        (("x".repeat(STAGE_SIZE)) +
            ("x" + ".".repeat(STAGE_SIZE - 2) + "x\n").repeat(STAGE_SIZE - 2) +
            ("x".repeat(STAGE_SIZE)))
    }

    var isUp: Boolean = false
    var isDown: Boolean = false
    var isLeft: Boolean = false
    var isRight: Boolean = false

    private val actors: MutableMap<Char?, Actor> = LinkedHashMap<Char?, Actor>()

    val spots: MutableList<Spot> = mutableListOf()
    val images: MutableMap<Char, ByteArray> = mutableMapOf()

    var all: ActorStates

    fun some() : Logger {
        return LoggerFactory.getLogger(this::class.java)
    }

    init {
        ServiceLoader.load(ActorSet::class.java).forEach { set ->
            actors.putAll(set.items().associateBy { a -> a.symbol })
        }
        ServiceLoader.load(AssetSet::class.java).forEach { set ->
            images.putAll(set.assets().associate { a -> a.symbol to a.image })
        }
        val stage = ServiceLoader.load(Stage::class.java).firstOrNull() ?: emptyDefault

        val renderedStage = Spot.render(stage).toList()
        val prototypes = mutableMapOf<Char, Spot>()

        org.slf4j.LoggerFactory.getLogger(GameState::class.java);

        renderedStage.forEach { spot ->
            if (actors.containsKey(spot.symbol)) {
                spots.addFirst(spot.clone(SYMBOL_EMPTY_SPOT))
                val item = actors[spot.symbol]!!
                spot.init(
                    item.modifiers
                        .stream()
                        .collect(
                            Collectors.toMap(ActorPropertyModifier::p, ActorPropertyModifier::value)
                        ),
                    item.collisionFunctions,
                )
                spots.add(spot)
                prototypes[spot.symbol] = spot
            } else {
                spots.addFirst(spot)
            }
        }
        all = ActorStatesImpl(spots, spots, prototypes)
    }

    fun action() {
        println("Boom!")
    }
}
