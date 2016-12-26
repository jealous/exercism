import java.util.Calendar.{DATE, DAY_OF_WEEK}
import java.util.GregorianCalendar

import scala.annotation.tailrec

/**
  *
  * @author Cedric Zhuang
  *
  */
case class Meetup(month: Int, year: Int) {

  def teenth(weekday: Meetup.Weekday): GregorianCalendar =
    getDay(13, weekday)

  def first(weekday: Meetup.Weekday): GregorianCalendar =
    getDay(1, weekday)

  def second(weekday: Meetup.Weekday): GregorianCalendar =
    getDay(8, weekday)

  def third(weekday: Meetup.Weekday): GregorianCalendar =
    getDay(15, weekday)

  def fourth(weekday: Meetup.Weekday): GregorianCalendar =
    getDay(22, weekday)

  def last(weekday: Meetup.Weekday): GregorianCalendar = {
    val dayMonth = new GregorianCalendar(year, month - 1, 1).getActualMaximum(DATE)
    getDay(dayMonth - 6, weekday)
  }

  @tailrec
  private def getDay(from: Int, wd: Meetup.Weekday): GregorianCalendar = {
    val day = new GregorianCalendar(year, month - 1, from)
    if (day.get(DAY_OF_WEEK) == wd.id + 1)
      day
    else
      getDay(from + 1, wd)
  }
}

object Meetup extends Enumeration {
  type Weekday = Value
  val Sun, Mon, Tue, Wed, Thu, Fri, Sat = Value
}
