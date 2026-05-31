package org.example.javarca.engine

import kotlin.math.max
import kotlin.math.min
import org.example.javarca.model.*
import org.example.javarca.model.GameConstants.PRECISION
import org.example.javarca.model.GameConstants.STAGE_SIZE
import org.example.javarca.model.GameConstants.SYMBOL_EMPTY_SPOT

/** The implementation of [ActorState]. */
class Spot(val symbol: Char, x: Int, y: Int) : ActorState {
    private val collisionFunctions: MutableMap<Char, ActorCollision> = mutableMapOf()
    private val initialValues: MutableMap<ActorProperty, Int> = mutableMapOf()
    private val values: MutableMap<ActorProperty, Int> = mutableMapOf()

    var skin = symbol
    private var isAlive = true
    private var x = PRECISION * x
    private var y = PRECISION * y

    constructor(
        symbol: Char,
        posInStream: Int,
    ) : this(
        symbol,
        posInStream - (posInStream / STAGE_SIZE) * STAGE_SIZE,
        posInStream / STAGE_SIZE,
    )

    fun clone(newSymbol: Char): Spot {
        val clone = Spot(newSymbol, x / PRECISION, y / PRECISION)
        clone.init(initialValues, collisionFunctions)
        return clone
    }

    fun clone(newSymbol: Char, x: Int, y: Int): Spot {
        val clone = Spot(newSymbol, x, y)
        clone.init(initialValues, collisionFunctions)
        return clone
    }

    override fun toString(): String {
        return symbol.toString() + "(" + (x * 1f) / PRECISION + "|" + (y * 1f) / PRECISION + ")"
    }

    fun init(
        initialValues: Map<ActorProperty, Int>,
        collisionFunctions: Map<Char, ActorCollision>,
    ) {
        this.initialValues.putAll(initialValues)
        this.collisionFunctions.putAll(collisionFunctions)
    }

    override fun setSkin(skin: Char): Char {
        this.skin = skin
        return this.skin
    }

    override fun getValue(p: ActorProperty): Int {
        return values.getOrElse(p) { initialValues.getOrElse(p) { 0 } }
    }

    override fun setValue(p: ActorProperty, value: Int): Int {
        values[p] = value
        return getValue(p)
    }

    override fun resetValue(p: ActorProperty): Int {
        values.remove(p)
        return getValue(p)
    }

    override fun addToValue(p: ActorProperty, increment: Int): Int {
        values[p] = getValue(p) + increment
        return getValue(p)
    }

    override fun multiplyValue(p: ActorProperty, multiplier: Int): Int {
        values[p] = getValue(p) * multiplier
        return getValue(p)
    }

    override fun x(): Int {
        return x
    }

    override fun setX(x: Int): Int {
        this.x = x
        return x
    }

    override fun y(): Int {
        return y
    }

    override fun setY(y: Int): Int {
        this.y = y
        return y
    }

    override fun destroy() {
        this.isAlive = false
    }

    override fun isAlive(): Boolean {
        return isAlive
    }

    fun getPixelPositionX(cellWidthInPixel: Int): Float {
        if (!this.isAlive) {
            return Float.MIN_VALUE
        }
        return (x * cellWidthInPixel) * 1f / PRECISION
    }

    fun getPixelPositionY(cellHeightInPixel: Int): Float {
        if (!this.isAlive) {
            return Float.MIN_VALUE
        }
        return (y * cellHeightInPixel) * 1f / PRECISION
    }

    private fun blocks(): Boolean {
        return getValue(ActorProperty.BLOCKING) == 1 || getValue(ActorProperty.DESTRUCTIBLE) == 1
    }

    fun move(deltaX: Int, deltaY: Int, allSpots: MutableList<Spot>, all: ActorStates) {
        if (!this.isAlive) {
            return
        }

        collideSelf(all)

        if (deltaX == 0 && deltaY == 0) {
            return
        }

        val newX = min(max(0, x + deltaX), (STAGE_SIZE - 1) * PRECISION)
        val newY = min(max(0, y + deltaY), (STAGE_SIZE - 1) * PRECISION)

        val collisions =
            allSpots.filter { s ->
                s.isAlive && s.blocks() && s !== this && doesCollide(deltaX, deltaY, s)
            }
        if (!collisions.isEmpty()) {
            collisions.forEach { s -> collide(s, all) }

            // maybe we can still move part of the way
            if (deltaX != 0) {
                x = if (deltaX < 0) snapFloor(x) else snapCeil(x)
            }
            if (deltaY != 0) {
                y = if (deltaX < 0) snapFloor(y) else snapCeil(y)
            }
            return
        }

        x = newX
        y = newY
    }

    private fun snapFloor(value: Int): Int {
        return (value / PRECISION) * PRECISION
    }

    private fun snapCeil(value: Int): Int {
        val ceil: Int = ((value + PRECISION) / PRECISION) * PRECISION
        if (ceil == value + PRECISION) {
            return value
        }
        return ceil
    }

    private fun doesCollide(deltaX: Int, deltaY: Int, other: Spot): Boolean {
        return x + deltaX < other.x + PRECISION &&
            x + deltaX + PRECISION > other.x &&
            y + deltaY < other.y + PRECISION &&
            y + deltaY + PRECISION > other.y
    }

    private fun collide(other: Spot, all: ActorStates) {
        if (collisionFunctions.containsKey(other.symbol)) {
            collisionFunctions[other.symbol]!!.collide(this, other, all)
            if (symbol == other.symbol) {
                return // do not compute the same collision logic twice
            }
        }
        if (other.collisionFunctions.containsKey(symbol)) {
            other.collisionFunctions[symbol]!!.collide(other, this, all)
        }
    }

    private fun collideSelf(all: ActorStates) {
        if (collisionFunctions.containsKey(SYMBOL_EMPTY_SPOT)) {
            collisionFunctions[SYMBOL_EMPTY_SPOT]!!.collide(this, this, all)
        }
    }

    companion object {
        fun render(stage: Stage): List<Spot> {
            val symbols =
                stage.define().replace(" ", "").split("\n").flatMap { it.toCharArray().toList() }

            return (0 until STAGE_SIZE * STAGE_SIZE).map { p -> Spot(symbols[p], p) }
        }
    }
}
