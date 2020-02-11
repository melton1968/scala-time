package io.whitemice.time

import java.time.LocalDate

trait MarketCalendar {
  val holidays: Set[LocalDate]
  val partialDays: Set[LocalDate]
  val removedDays: Set[LocalDate]
}
