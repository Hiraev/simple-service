package service.impl

import model.Date
import service.DateService
import util.DateUtils

class DateServiceImpl : DateService {

    override fun find256day(year: Int): Date = DateUtils.toDate(256, year)

    override fun leftToProgrammerDay(dateString: String): Int {
        val date = Date.parseDate(dateString)
        val programmerDate = Date.of(13, 9, date.year)
        return if (date > programmerDate) {
            DateUtils.daysBetween(date, programmerDate.plusYear(1))
        } else {
            DateUtils.daysBetween(date, programmerDate)
        }
    }

}
