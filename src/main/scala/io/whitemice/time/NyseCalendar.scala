package io.whitemice.time

import java.time.LocalDate
import java.time.Month._

object NyseCalendar extends MarketCalendar {
  override val removedDays: Set[LocalDate] =
    Set(
      Seq(
      (2001, SEPTEMBER, 11), (2001, SEPTEMBER, 12), (2001, SEPTEMBER, 13), (2001, SEPTEMBER, 14),
      (2012, OCTOBER, 29), (2012, OCTOBER, 30),
      ).map{ tuple => LocalDate.of(tuple._1, tuple._2, tuple._3) }: _*
    )

  override val partialDays: Set[LocalDate] =
    Set(
      Seq(
        (2020, NOVEMBER, 27), (2020, DECEMBER, 24),
        (2021, NOVEMBER, 26),
        (2022, NOVEMBER, 25),
      ).map{ tuple => LocalDate.of(tuple._1, tuple._2, tuple._3) }: _*
    )

  override val holidays: Set[LocalDate] =
    Set(
      Seq(
        (2000, JANUARY, 1), (2000, JANUARY, 17), (2000, FEBRUARY, 21), (2000, APRIL, 21),
        (2000, MAY, 29), (2000, JULY, 4), (2000, SEPTEMBER, 4), (2000, NOVEMBER, 23),
        (2000, DECEMBER, 25),

        (2001, JANUARY, 1), (2001, JANUARY, 15), (2001, FEBRUARY, 19), (2001, APRIL, 13),
        (2001, MAY, 28), (2001, JULY, 4), (2001, SEPTEMBER, 3),
        (2001, NOVEMBER, 22), (2001, DECEMBER, 25),

        (2002, JANUARY, 1), (2002, JANUARY, 21), (2002, FEBRUARY, 18), (2002, MARCH, 29),
        (2002, MAY, 27), (2002, JULY, 4), (2002, SEPTEMBER, 2), (2002, NOVEMBER, 28),
        (2002, DECEMBER, 25),

        (2003, JANUARY, 1), (2003, JANUARY, 20), (2003, FEBRUARY, 17), (2003, APRIL, 18),
        (2003, MAY, 26), (2003, JULY, 4), (2003, SEPTEMBER, 1), (2003, NOVEMBER, 27),
        (2003, DECEMBER, 25),

        (2004, JANUARY, 1), (2004, JANUARY, 19), (2004, FEBRUARY, 16), (2004, APRIL, 9),
        (2004, MAY, 31), (2004, JUNE, 11), (2004, JULY, 5), (2004, SEPTEMBER, 2), (2004, NOVEMBER, 25),
        (2004, DECEMBER, 24),

        (2005, JANUARY, 17), (2005, FEBRUARY, 21), (2005, MARCH, 25),
        (2005, MAY, 30), (2005, JULY, 4), (2005, SEPTEMBER, 5), (2005, NOVEMBER, 24),
        (2005, DECEMBER, 26),

        (2006, JANUARY, 2), (2006, JANUARY, 16), (2006, FEBRUARY, 20), (2006, APRIL, 14),
        (2006, MAY, 29), (2006, JULY, 4), (2006, SEPTEMBER, 4), (2006, NOVEMBER, 23),
        (2006, DECEMBER, 25),

        (2007, JANUARY, 1), (2007, JANUARY, 2), (2007, JANUARY, 15), (2007, FEBRUARY, 19), (2007, APRIL, 6),
        (2007, MAY, 28), (2007, JULY, 4), (2007, SEPTEMBER, 3), (2007, NOVEMBER, 22),
        (2007, DECEMBER, 25),

        (2008, JANUARY, 1), (2008, JANUARY, 19), (2008, FEBRUARY, 16), (2008, APRIL, 10), (2008, MARCH, 25),
        (2008, MAY, 25), (2008, JULY, 3), (2008, SEPTEMBER, 7), (2008, NOVEMBER, 26),
        (2008, DECEMBER, 25),

        (2009, JANUARY, 1), (2009, JANUARY, 19), (2009, FEBRUARY, 16), (2009, APRIL, 10),
        (2009, MAY, 25), (2009, JULY, 3), (2009, SEPTEMBER, 7), (2009, NOVEMBER, 26),
        (2009, DECEMBER, 25),

        (2010, JANUARY, 1), (2010, JANUARY, 18), (2010, FEBRUARY, 15), (2010, APRIL, 2),
        (2010, MAY, 31), (2010, JULY, 5), (2010, SEPTEMBER, 6), (2010, NOVEMBER, 25),
        (2010, DECEMBER, 24),

        (2011, JANUARY, 17), (2011, FEBRUARY, 21), (2011, APRIL, 22),
        (2011, MAY, 30), (2011, JULY, 4), (2011, SEPTEMBER, 5), (2011, NOVEMBER, 24),
        (2011, DECEMBER, 26),

        (2012, JANUARY, 2), (2012, JANUARY, 16), (2012, FEBRUARY, 20), (2012, APRIL, 6),
        (2012, MAY, 28), (2012, JULY, 4), (2012, SEPTEMBER, 3), (2012, NOVEMBER, 22),
        (2012, DECEMBER, 25),

        (2013, JANUARY, 1), (2013, JANUARY, 21), (2013, FEBRUARY, 18), (2013, MARCH, 29),
        (2013, MAY, 27), (2013, JULY, 4), (2013, SEPTEMBER, 2), (2013, NOVEMBER, 28),
        (2013, DECEMBER, 25),

        (2014, JANUARY, 1), (2014, JANUARY, 20), (2014, FEBRUARY, 17), (2014, APRIL, 18),
        (2014, MAY, 26), (2014, JULY, 4), (2014, SEPTEMBER, 1), (2014, NOVEMBER, 27),
        (2014, DECEMBER, 25),

        (2015, JANUARY, 1), (2015, JANUARY, 19), (2015, FEBRUARY, 16), (2015, APRIL, 3),
        (2015, MAY, 25), (2015, JULY, 3), (2015, SEPTEMBER, 7), (2015, NOVEMBER, 26),
        (2015, DECEMBER, 25),

        (2016, JANUARY, 1), (2016, JANUARY, 18), (2016, FEBRUARY, 15), (2016, MARCH, 25),
        (2016, MAY, 30), (2016, JULY, 4), (2016, SEPTEMBER, 5), (2016, NOVEMBER, 24),
        (2016, DECEMBER, 25),

        (2017, JANUARY, 2), (2017, JANUARY, 16), (2017, FEBRUARY, 20), (2017, APRIL, 14),
        (2017, MAY, 29), (2017, JULY, 4), (2017, SEPTEMBER, 4), (2017, NOVEMBER, 23),
        (2017, DECEMBER, 25),

        (2018, JANUARY, 1), (2018, JANUARY, 15), (2018, FEBRUARY, 19), (2018, MARCH, 30),
        (2018, MAY, 28), (2018, JULY, 4), (2018, SEPTEMBER, 3), (2018, NOVEMBER, 22),
        (2018, DECEMBER, 25),

        (2019, JANUARY, 1), (2019, JANUARY, 21), (2019, FEBRUARY, 18), (2019, APRIL, 19),
        (2019, MAY, 27), (2019, JULY, 4), (2019, SEPTEMBER, 2), (2019, NOVEMBER, 28),
        (2019, DECEMBER, 25),

        (2020, JANUARY, 1), (2020, JANUARY, 20), (2020, FEBRUARY, 17), (2020, APRIL, 10),
        (2020, MAY, 25), (2021, JULY, 3), (2020, SEPTEMBER, 7), (2020, NOVEMBER, 26),
        (2020, DECEMBER, 25),

        (2021, JANUARY, 1), (2021, JANUARY, 18), (2021, FEBRUARY, 15), (2021, APRIL, 2),
        (2021, MAY, 31), (2021, JULY, 5), (2021, SEPTEMBER, 6), (2021, NOVEMBER, 25),
        (2021, DECEMBER, 24),

        (2022, JANUARY, 17), (2022, FEBRUARY, 21), (2022, APRIL, 15),
        (2022, MAY, 30), (2022, JULY, 4), (2022, SEPTEMBER, 5), (2022, NOVEMBER, 24),
        (2022, DECEMBER, 26),
      ).map{ tuple => LocalDate.of(tuple._1, tuple._2, tuple._3) }: _*
    )

}
