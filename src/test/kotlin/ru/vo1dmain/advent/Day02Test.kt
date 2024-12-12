package ru.vo1dmain.advent

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Day 2")
class Day02Test {
    private val exampleInput = """
        7 6 4 2 1
        1 2 7 8 9
        9 7 6 2 1
        1 3 2 4 5
        8 6 4 4 1
        1 3 6 7 9
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {
            val input = parse(exampleInput)
            val result = Day02.countSafeReports(input)

            assertEquals(2, result)
        }

        @Test
        fun `Matches answer`() {
            val lines = resource("/inputs/Day02.txt").readText().lines()
            val input = parse(lines)
            val result = Day02.countSafeReports(input)

            assertEquals(486, result)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val input = parse(exampleInput)
            val result = Day02.countSafeReportsDampened(input)

            assertEquals(4, result)
        }

        @Test
        fun `Matches answer`() {
            val lines = resource("/inputs/Day02.txt").readText().lines()
            val input = parse(lines)
            val result = Day02.countSafeReportsDampened(input)

            assertEquals(540, result)
        }
    }

    private fun parse(input: List<String>): List<List<Int>> {
        return input.map { line ->
            line.split(' ').map<String, Int>(String::toInt)
        }
    }
}