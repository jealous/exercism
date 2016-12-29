/**
  *
  * @author Cedric Zhuang
  *
  */
object Series {
  def largestProduct(i: Int, s: String): Option[Int] =
    if (i == 0) Some(1)
    else if (s.isEmpty || i > s.length) None
    else Some(calculate(i, s))

  private def calculate(i: Int, s: String): Int =
    s.map(_ - '0').sliding(i).map(_.product).max
}
