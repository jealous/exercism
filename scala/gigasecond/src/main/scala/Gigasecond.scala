import java.util.Calendar.SECOND
import java.util.GregorianCalendar

/**
  *
  * @author Cedric Zhuang
  *
  */
case class Gigasecond(gc: GregorianCalendar) {
  lazy val date: GregorianCalendar = {
    val ret = gc.clone.asInstanceOf[GregorianCalendar]
    ret.add(SECOND, 1e9.toInt)
    ret
  }
}
