package service

import model.Date

interface DateService {

    fun find256day(year: Int): Date

    fun leftToProgrammerDay(dateString: String): Int

}
