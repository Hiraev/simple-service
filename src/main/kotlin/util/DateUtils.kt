package util

import extension.reduceUntil
import model.Date

object DateUtils {

    private val regularYear = arrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    private val leapYear = arrayOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

    private const val REGULAR_YEAR_DAYS = 365
    private const val LEAP_YEAR_DAYS = 366

    fun checkAvailability(day: Int, month: Int, year: Int): Boolean {
        if (day < 1 || month < 1 || month > 12 || year < 0) return false
        if (isLeapYear(year)) {
            if (day > leapYear[month - 1]) return false
        } else {
            if (day > regularYear[month - 1]) return false
        }
        return true
    }

    @Throws(exceptionClasses = [IllegalArgumentException::class])
    fun toDate(dayOfYear: Int, year: Int): Date {
        require(year >= 0 && dayOfYear >= 1)
        val isLeap = isLeapYear(year)
        val (allDays, monthIndex) = if (isLeap) {
            require(dayOfYear <= LEAP_YEAR_DAYS)
            findRestDaysAndMonth(leapYear, dayOfYear)
        } else {
            require(dayOfYear <= REGULAR_YEAR_DAYS)
            findRestDaysAndMonth(regularYear, dayOfYear)
        }
        val day = if (dayOfYear <= 31) dayOfYear else dayOfYear - (allDays - if (isLeap) leapYear[monthIndex] else regularYear[monthIndex])
        return Date.of(day, monthIndex + 1, year)
    }

    @Throws(exceptionClasses = [IllegalArgumentException::class])
    fun daysBetween(from: Date, to: Date): Int {
        require(from <= to)
        val yearsBetween = to.year - from.year
        return if (yearsBetween == 0) {
            if (from.month == to.month) {
                to.day - from.day
            } else {
                val array = if (isLeapYear(from.year)) leapYear else regularYear
                array.sliceArray(from.month - 1 until to.month).sum() - from.day - (array[to.month - 1] - to.day)
            }
        } else {
            val dayInMiddleYears = List(yearsBetween - 1) { from.year + it + 1 }
                    .map { if (isLeapYear(it)) LEAP_YEAR_DAYS else REGULAR_YEAR_DAYS }
                    .sum()
            daysToEndOfYear(from) + daysFromStartOfYear(to) + dayInMiddleYears
        }
    }

    private fun daysFromStartOfYear(date: Date) = date.day + (if (isLeapYear(date.year)) leapYear else regularYear).take(date.month - 1).sum()

    private fun daysToEndOfYear(date: Date) = (if (isLeapYear(date.year)) LEAP_YEAR_DAYS else REGULAR_YEAR_DAYS) - daysFromStartOfYear(date)

    private fun findRestDaysAndMonth(array: Array<Int>, lim: Int) = array
            .reduceUntil(predicate = { acc -> acc < lim }) { acc, elem ->
                acc + elem
            }

    private fun isLeapYear(year: Int): Boolean = year % 4 == 0 && year % 100 != 0 || year % 400 == 0

}
