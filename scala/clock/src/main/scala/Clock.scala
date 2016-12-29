/**
  *
  * @author Cedric Zhuang
  *
  */
object Clock {
  def apply(m: Int): Clock = new Clock(0, m)
}

case class Clock(h: Int, m: Int) {
  private lazy val totalMinutes = Math.floorMod(h * 60 + m, 24 * 60)

  lazy val hour: Int = totalMinutes / 60

  lazy val minute: Int = totalMinutes % 60

  def +(other: Clock): Clock = Clock(h + other.h, m + other.m)

  def -(other: Clock): Clock = Clock(h - other.h, m - other.m)

  override def toString: String = f"$hour%02d:$minute%02d"

  override def equals(obj: scala.Any): Boolean =
    obj.isInstanceOf[Clock] && obj.toString == toString
}
