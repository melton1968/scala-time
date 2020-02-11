package io.whitemice.time

import java.time.{DayOfWeek, LocalDate}

class MarketDate(val date: LocalDate) {

  def isWeekDay: Boolean = {
    date.getDayOfWeek match {
      case DayOfWeek.SATURDAY | DayOfWeek.SUNDAY => false
      case _ => true
    }
  }

  def isMarketOpen()(implicit holidays: Set[LocalDate]): Boolean = {
    if (holidays.contains(date)) false else isWeekDay
  }

}
