package ru.vo1dmain.advent.utils

data class Point(
    val x: Int,
    val y: Int
)

operator fun Point.plus(other: Point): Point {
    return copy(x + other.x, y + other.y)
}

infix fun Int.at(y: Int): Point {
    return Point(this, y)
}