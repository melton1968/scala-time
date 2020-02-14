package io.whitemice.time

import org.scalatest.{FlatSpec, Matchers, OptionValues}
import java.time.LocalDate
import java.time.temporal.{ChronoUnit, TemporalUnit}

class MarketDateUnitTest extends FlatSpec with Matchers with OptionValues {

  "isMarketOpen" should "return false for a Saturday" in {
    val date = LocalDate.of(2019,12,28)
    date.isMarketOpen shouldEqual false
  }

  it should "return false for a Sunday" in {
    val date = LocalDate.of(2019,12,28)
    date.isMarketOpen() shouldEqual false
  }

  it should "return false for Christmas" in {
    val date = LocalDate.of(2019,12,25)
    date.isMarketOpen() shouldEqual false
  }

  it should "return false for unplanned market closures" in {
    val date = LocalDate.of(2001,9,11)
    date.isMarketOpen() shouldEqual false
  }

  it should "return true a normal trading day" in {
    val date = LocalDate.of(2019,12,30)
    date.isMarketOpen() shouldEqual true
  }

  "nextMarketDay" should "return the next day" in {
    val date = LocalDate.of(2020, 1, 2)
    date.nextMarketDay() shouldEqual LocalDate.of(2020, 1, 3)
  }

  it should "advance past the weekend" in {
    val date = LocalDate.of(2020, 1, 3)
    date.nextMarketDay() shouldEqual LocalDate.of(2020, 1, 6)
  }

  it should "advance out of the weekend" in {
    val date = LocalDate.of(2020, 1, 5)
    date.nextMarketDay() shouldEqual LocalDate.of(2020, 1, 6)
  }

  it should "advance past a holiday" in {
    val date = LocalDate.of(2019, 12, 31)
    date.nextMarketDay() shouldEqual LocalDate.of(2020, 1, 2)
  }

  it should "advance out of a holiday" in {
    val date = LocalDate.of(2020, 1, 1)
    date.nextMarketDay() shouldEqual LocalDate.of(2020, 1, 2)
  }

  "prevMarketDay" should "return the previous day" in {
    val date = LocalDate.of(2020, 1, 3)
    date.prevMarketDay() shouldEqual LocalDate.of(2020, 1, 2)
  }

  it should "advance past the weekend" in {
    val date = LocalDate.of(2020, 1, 6)
    date.prevMarketDay() shouldEqual LocalDate.of(2020, 1, 3)
  }

  it should "advance out of the weekend" in {
    val date = LocalDate.of(2020, 1, 5)
    date.prevMarketDay() shouldEqual LocalDate.of(2020, 1, 3)
  }

  it should "advance past a holiday" in {
    val date = LocalDate.of(2020, 1, 2)
    date.prevMarketDay() shouldEqual LocalDate.of(2019, 12, 31)
  }

  it should "advance out of a holiday" in {
    val date = LocalDate.of(2020, 1, 1)
    date.prevMarketDay() shouldEqual LocalDate.of(2019, 12, 31)
  }

  "marketTo" should "range over the open market days inclusive" in {
    val start = LocalDate.of(2019, 12, 30)
    val end = LocalDate.of(2020, 1, 6)
    val days = start marketTo end
    days.length shouldEqual 5
    days(0) shouldEqual start
    days(1) shouldEqual LocalDate.of(2019, 12, 31)
    days(2) shouldEqual LocalDate.of(2020, 1, 2)
    days(3) shouldEqual LocalDate.of(2020, 1, 3)
    days(4) shouldEqual end
  }

  it should "cross month boundaries" in {
    val start = LocalDate.of(2019, 11, 20)
    val end = LocalDate.of(2019, 12, 20)
    val days = start marketTo end
    days.length shouldEqual 22
    days.head shouldEqual start
    days.last shouldEqual end
  }

  "marketUntil" should "range over the open market days exclusive" in {
    val start = LocalDate.of(2019, 12, 30)
    val end = LocalDate.of(2020, 1, 6)
    val days = start marketUntil end
    days.length shouldEqual 4
    days(0) shouldEqual start
    days(1) shouldEqual LocalDate.of(2019, 12, 31)
    days(2) shouldEqual LocalDate.of(2020, 1, 2)
    days(3) shouldEqual LocalDate.of(2020, 1, 3)
  }

}
