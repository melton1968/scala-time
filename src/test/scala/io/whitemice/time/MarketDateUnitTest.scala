package io.whitemice.time

import org.scalatest.{FlatSpec, Matchers, OptionValues}
import java.time.LocalDate

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

}
