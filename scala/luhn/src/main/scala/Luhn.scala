/**
  *
  * @author Cedric Zhuang
  *
  */
case class Luhn(n: Long) {
  private def calc(c: Char, i: Int): Long = {
    val l: Long = c - '0'
    if (i % 2 == 0) l
    else if (l * 2 >= 10) l * 2 - 9
    else l * 2
  }

  lazy val checkDigit: Long = n % 10

  lazy val addends: List[Long] =
    n.toString.reverse.zipWithIndex
      .map { case (c, i) => calc(c, i) }
      .reverse.toList

  lazy val checksum: Long = addends.sum % 10

  lazy val isValid: Boolean = Luhn(n).checksum == 0

  lazy val create: Long = (10 - Luhn(n * 10).checksum) % 10 + n * 10
}
