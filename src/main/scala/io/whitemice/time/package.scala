package io.whitemice

import java.time.LocalDate

package object time {
  implicit val marketCalendar: MarketCalendar = NyseCalendar
  implicit def dateToMarketDate(date: LocalDate): MarketDate = new MarketDate(date)
}
