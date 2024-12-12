package ru.vo1dmain.advent

object Day03 {
    private val mulRegex = """mul\((\d{1,3}),(\d{1,3})\)""".toRegex()

    private val conditionsRegex = """(^|do\(\)).*?($|don't\(\))""".toRegex()

    fun findCorrect(memory: String): Int {
        return mulRegex.findAll(memory).sumOf { result ->
           val (left, right) = result.destructured
           left.toInt() * right.toInt()
        }
    }

    fun findEnabled(memory: String): Int {
        return conditionsRegex.findAll(memory).sumOf { result ->
            findCorrect(result.value)
        }
    }
}