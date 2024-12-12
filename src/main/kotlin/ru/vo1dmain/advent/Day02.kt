package ru.vo1dmain.advent

object Day02 {
    private val safeRangeDesc = 1..3

    private val safeRangeAsc = -3..-1

    fun countSafeReports(reports: List<List<Int>>): Int {
        return reports.count { isSafe(it) }
    }

    fun countSafeReportsDampened(reports: List<List<Int>>): Int {
        return reports.count { isSafeDampened(it) }
    }

    private fun isSafe(report: List<Int>): Boolean {
        val distances = report.zipWithNext { left, right -> left - right }
        return distances.all { it in safeRangeDesc } || distances.all { it in safeRangeAsc }
    }

    private fun isSafeDampened(report: List<Int>): Boolean {
        return report.indices.any { excluded ->
            val filtered = report.filterIndexed { index, _ -> index != excluded }
            isSafe(filtered)
        }
    }
}