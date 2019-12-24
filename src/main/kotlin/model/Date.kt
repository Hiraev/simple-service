package model

import util.DateUtils

class Date private constructor(
        val day: Int,
        val month: Int,
        val year: Int
) {


    companion object {

        @Throws(exceptionClasses = [IllegalArgumentException::class])
        fun of(day: Int, month: Int, year: Int): Date {
            require(DateUtils.checkAvailability(day, month, year))
            return Date(day, month, year)
        }

        /**
         * dateString - string in format: ddmmYYYY
         */
        @Throws(exceptionClasses = [IllegalArgumentException::class])
        fun parseDate(dateString: String): Date {
            require(dateString.length == 8)
            try {
                val day = dateString.substring(0..1).toInt()
                val month = dateString.substring(2..3).toInt()
                val year = dateString.substring(4..7).toInt()
                return of(day, month, year)
            } catch (t: Throwable) {
                throw IllegalArgumentException()
            }
        }

    }

    operator fun compareTo(other: Date) = when {
        year != other.year -> {
            year.compareTo(other.year)
        }
        month != other.month -> {
            month.compareTo(other.month)
        }
        else -> {
            day.compareTo(other.day)
        }
    }

    override fun equals(other: Any?): Boolean {
        val otherDate = (other as? Date) ?: return false
        return day == otherDate.day && month == other.month && year == other.year
    }

    override fun hashCode(): Int {
        return (day.hashCode() + month.hashCode() + year.hashCode()) * 31
    }

    override fun toString(): String = toStringThatTeachersWant()

    fun plusYear(years: Int): Date {
        require(years >= 0)
        require(DateUtils.checkAvailability(day, month, year + years))
        return Date(day, month, year + years)
    }

    fun toStringThatTeachersWant() = day.toString().padStart(2, '0') +
            '/' +
            month.toString().padStart(2, '0') +
            '/' +
            year

}
