package org.example.javarca.model

/** Provide the graphical asset for a given symbol as a byte stream that encodes a PNG image. */
data class Asset(val symbol: Char, val image: ByteArray)
