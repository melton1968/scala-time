package io.whitemice.time

import java.time.{DayOfWeek, LocalDate}

class MarketDate(val date: LocalDate) {

  def isWeekDay: Boolean = {
    date.getDayOfWeek match {
      case DayOfWeek.SATURDAY | DayOfWeek.SUNDAY => false
      case _ => true
    }
  }

  def isMarketOpen()(implicit marketCalendar: MarketCalendar): Boolean = {
    if (marketCalendar.holidays.contains(date)) false
    else if (marketCalendar.partialDays.contains(date)) false
    else if (marketCalendar.removedDays.contains(date)) false
    else isWeekDay
  }

}
