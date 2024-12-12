package ru.vo1dmain.advent

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Day 4")
class Day04Test {
    private val exampleInput = """
        MMMSXXMASM
        MSAMXMSMSA
        AMXSXMAAMM
        MSAMASMSMX
        XMASAMXAMM
        XXAMMXXAMA
        SMSMSASXSS
        SAXAMASAAA
        MAMMMXMMMM
        MXMXAXMASX
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {
            val answer = Day04.countAll(exampleInput)
            assertEquals(18, answer)
        }

        @Test
        fun `Matches answer`() {
            val input = resource("/inputs/Day04.txt").readText().lines()
            val answer = Day04.countAll(input)
            assertEquals(2567, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            val answer = Day04.countCrossShaped(exampleInput)
            assertEquals(9, answer)
        }

        @Test
        fun `Matches answer`() {
            val input = resource("/inputs/Day04.txt").readText().lines()
            val answer = Day04.countCrossShaped(input)
            assertEquals(2029, answer)
        }
    }
}