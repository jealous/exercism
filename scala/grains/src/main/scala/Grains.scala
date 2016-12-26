/**
  *
  * @author Cedric Zhuang
  *
  */
object Grains {

  def square(n: Int): Option[BigInt] = n match {
    case m if m > 0 && m <= 64 => Some(BigInt(1) << m - 1)
    case _ => None
  }

  lazy val total: BigInt = (BigInt(1) << 64) - 1
}
