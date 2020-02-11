package io.whitemice

import java.time.LocalDate

package object time {
  implicit val holidays: Set[LocalDate] = NyseCalendar.holidays
  implicit def dateToMarketDate(date: LocalDate): MarketDate = new MarketDate(date)
}
