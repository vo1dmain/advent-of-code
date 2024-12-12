package ru.vo1dmain.advent

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Day 3")
class Day03Test {
    private val exampleInput = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {
            val answer = Day03.findCorrect(exampleInput)
            assertEquals(161, answer)
        }

        @Test
        fun `Matches answer`() {
            val memory = resource("/inputs/Day03.txt").readText()
            val answer = Day03.findCorrect(memory)
            assertEquals(178_794_710, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            val answer = Day03.findEnabled(exampleInput)
            assertEquals(48, answer)
        }

        @Test
        fun `Matches answer`() {
            val memory = resource("/inputs/Day03.txt").readText()
            val answer = Day03.findEnabled(memory)
            assertEquals(76_729_637, answer)
        }
    }
}