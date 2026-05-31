package org.example.javarca.engine.impl

import org.example.javarca.engine.Spot
import org.example.javarca.model.ActorProperty
import org.example.javarca.model.ActorState
import org.example.javarca.model.ActorStates

class ActorStatesImpl(
    private val spots: List<Spot>,
    private val root: MutableList<Spot>,
    private val prototypes: Map<Char, Spot>,
) : ActorStates {
    override fun filter(symbol: Char): ActorStates {
        return ActorStatesImpl(
            spots.filter { it.isAlive() && it.symbol == symbol },
            root,
            prototypes,
        )
    }

    override fun filter(p: ActorProperty, value: (Int) -> Boolean): ActorStates {
        return ActorStatesImpl(
            spots.filter { it.isAlive() && value(it.getValue(p)) },
            root,
            prototypes,
        )
    }

    override fun print(value: String) {
        var i = 0
        while (i < spots.size && i < value.length) {
            spots[i].setSkin(value[i])
            i++
        }
    }

    override fun print(value: Int) {
        val s = value.toString().padStart(spots.size, '0')
        var i = 0
        while (i < spots.size && i < s.length) {
            spots[i].setSkin(s[i])
            i++
        }
    }

    override fun setSkin(c: Char) {
        spots.forEach { it.setSkin(c) }
    }

    override fun destroy() {
        spots.forEach { it.destroy() }
    }

    override fun setX(x: Int): Int {
        spots.forEach { it.setX(x) }
        return x
    }

    override fun setY(y: Int): Int {
        spots.forEach { it.setY(y) }
        return y
    }

    override fun minY(): Int = spots.minOfOrNull { it.y() } ?: 0

    override fun maxY(): Int = spots.maxOfOrNull { it.y() } ?: 0

    override fun minX(): Int = spots.minOfOrNull { it.x() } ?: 0

    override fun maxX(): Int = spots.maxOfOrNull { it.x() } ?: 0

    override fun spawn(symbol: Char, x: Int, y: Int): ActorState {
        return spawn(symbol, x, y, symbol)
    }

    override fun spawn(symbol: Char, x: Int, y: Int, skin: Char): ActorState {
        val prototype = prototypes[symbol]
        val newSpot = prototype?.clone(symbol, x, y) ?: Spot(symbol, x, y)
        newSpot.setSkin(skin)
        root.add(newSpot)
        return newSpot
    }
}
