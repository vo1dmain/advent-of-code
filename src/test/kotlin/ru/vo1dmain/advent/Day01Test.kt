package ru.vo1dmain.advent

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Day 1")
class Day01Test {
    private val splitter = "\\s{3}".toRegex()

    private val exampleInput = """
        3   4
        4   3
        2   5
        1   3
        3   9
        3   3
        """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {
            val lists = parse(exampleInput)
            val answer = Day01.findDistance(lists.first, lists.second)

            assertEquals(11, answer)
        }

        @Test
        fun `Matches answer`() {
            val lines = resource("/inputs/Day01.txt").readText().lines()
            val lists = parse(lines)
            val answer = Day01.findDistance(lists.first, lists.second)

            assertEquals(1_873_376, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            val lists = parse(exampleInput)
            val answer = Day01.findSimilarity(lists.first, lists.second)

            assertEquals(31, answer)
        }

        @Test
        fun `Matches answer`() {
            val lines = resource("/inputs/Day01.txt").readText().lines()
            val lists = parse(lines)
            val answer = Day01.findSimilarity(lists.first, lists.second)

            assertEquals(18_997_088, answer)
        }
    }

    private fun parse(input: List<String>): Pair<List<Int>, List<Int>> {
        val leftList = mutableListOf<Int>()
        val rightList = mutableListOf<Int>()

        input.forEach { string ->
            val line = string.split(splitter)
            leftList.add(line[0].toInt())
            rightList.add(line[1].toInt())
        }

        return leftList to rightList
    }
}