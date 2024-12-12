package ru.vo1dmain.advent

import ru.vo1dmain.advent.utils.Point
import ru.vo1dmain.advent.utils.at
import ru.vo1dmain.advent.utils.plus

object Day04 {
    private const val WORD = "XMAS"

    private val up = 0 at -1
    private val right = 1 at 0
    private val down = 0 at 1
    private val left = -1 at 0

    private val upLeft = up + left
    private val upRight = up + right
    private val downLeft = down + left
    private val downRight = down + right

    private val directions = arrayOf<Point>(
        upLeft, up, upRight,
        left, right,
        downLeft, down, downRight
    )

    fun countAll(input: List<String>): Int {
        val firstChar = WORD[0]

        var counter = 0
        for (y in input.indices) {

            val line = input[y]
            for (x in line.indices) {

                val char = line[x]
                if (char != firstChar) continue

                counter += directions.count { direction ->
                    containsTargetWord(0, WORD, input, x at y, direction)
                }
            }
        }

        return counter
    }

    fun countCrossShaped(input: List<String>): Int {
        val centralChar = 'A'
        val firstChar = 'S'
        val secondChar = 'M'

        var counter = 0
        for (y in input.indices) {

            val line = input[y]
            for (x in line.indices) {

                val char = line[x]
                if (char != centralChar) continue

                val currentPoint = x at y

                val upLeftPoint = upLeft + currentPoint
                if (!input.containsPoint(upLeftPoint)) continue

                val upRightPoint = upRight + currentPoint
                if (!input.containsPoint(upRightPoint)) continue

                val downLeftPoint = downLeft + currentPoint
                if (!input.containsPoint(downLeftPoint)) continue

                val downRightPoint = downRight + currentPoint
                if (!input.containsPoint(downRightPoint)) continue

                val ulChar = input[upLeftPoint.y][upLeftPoint.x]
                val urChar = input[upRightPoint.y][upRightPoint.x]
                val dlChar = input[downLeftPoint.y][downLeftPoint.x]
                val drChar = input[downRightPoint.y][downRightPoint.x]

                val hasFirstMatch = ulChar == firstChar && drChar == secondChar
                        || ulChar == secondChar && drChar == firstChar

                val hasSecondMatch = urChar == firstChar && dlChar == secondChar
                        || urChar == secondChar && dlChar == firstChar

                if (hasFirstMatch && hasSecondMatch)
                    counter++
            }
        }

        return counter
    }

    private tailrec fun containsTargetWord(
        charIndex: Int,
        word: String,
        input: List<String>,
        position: Point,
        direction: Point
    ): Boolean {
        val (x, y) = position
        return when {
            charIndex !in word.indices -> true
            input.containsPoint(position).not() -> false
            input[y][x] != word[charIndex] -> false
            else -> containsTargetWord(charIndex + 1, word, input, position + direction, direction)
        }
    }

    private fun List<String>.containsPoint(point: Point): Boolean {
        return point.y in indices
                && point.x in this[point.y].indices
    }
}