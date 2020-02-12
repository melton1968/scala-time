package io.whitemice

import java.time.{Instant, LocalDate, ZoneId}

package object time {
  implicit val marketCalendar: MarketCalendar = NyseCalendar
  implicit def dateToMarketDate(date: LocalDate): MarketDate = new MarketDate(date)

  implicit def timeStampToInstant(tm: TimeStamp): Instant =
    Instant.ofEpochSecond(tm.tm / 1000000000, tm.tm % 1000000000)

  implicit def timeStampToMarketDate(tm: TimeStamp): MarketDate = {
    val instant = Instant.ofEpochSecond(tm.tm / 1000000000, tm.tm % 1000000000)
    val localDate = instant.atZone(ZoneId.of("America/New_York")).toLocalDate
    new MarketDate(localDate)
  }
}
