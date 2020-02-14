package io.whitemice.time

import java.time.temporal.ChronoUnit
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

  def nextMarketDay()(implicit marketCalendar: MarketCalendar): LocalDate = {
    val newDate = date.plusDays(1)
    if (newDate.isMarketOpen()(marketCalendar)) newDate
    else newDate.nextMarketDay()(marketCalendar)
  }

  def prevMarketDay()(implicit marketCalendar: MarketCalendar): LocalDate = {
    val newDate = date.plusDays(-1)
    if (newDate.isMarketOpen()(marketCalendar)) newDate
    else newDate.prevMarketDay()(marketCalendar)
  }

  def marketTo(end: LocalDate)(implicit marketCalendar: MarketCalendar): IndexedSeq[LocalDate] = {
    IndexedSeq.iterate(date, 1+ ChronoUnit.DAYS.between(date, end).toInt)(_.plusDays(1))
      .filter(_.isMarketOpen()(marketCalendar))
  }

  def marketUntil(end: LocalDate)(implicit marketCalendar: MarketCalendar): IndexedSeq[LocalDate] = {
    IndexedSeq.iterate(date, ChronoUnit.DAYS.between(date, end).toInt)(_.plusDays(1))
      .filter(_.isMarketOpen()(marketCalendar))
  }
}
