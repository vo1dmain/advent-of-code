package ru.vo1dmain.advent

import kotlin.math.absoluteValue


object Day01 {
    fun findDistance(
        leftList: List<Int>,
        rightList: List<Int>
    ): Int {
        val leftSorted = leftList.sorted()
        val rightSorted = rightList.sorted()

        return leftSorted.zip(rightSorted) { left, right ->
            (left - right).absoluteValue
        }.sum()
    }

    fun findSimilarity(
        leftList: List<Int>,
        rightList: List<Int>
    ): Int {
        val frequencyMap = rightList.groupingBy { it }.eachCount()
        return leftList.sumOf { value ->
            value * frequencyMap.getOrDefault(value, 0)
        }
    }
}

