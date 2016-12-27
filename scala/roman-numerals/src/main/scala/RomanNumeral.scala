/**
  *
  * @author Cedric Zhuang
  *
  */
case class RomanNumeral(n: Int) {
  lazy val value: String = (r1000(n) ::: r100(n) ::: r10(n) ::: r1(n)).mkString

  private def convert(m: Int)(one: Char, five: Char = ' ', ten: Char = ' '): List[Char] = {
    val n = m % 10
    val s: List[Char] = {
      if ((n + 1) / 5 == 1) five :: Nil
      else if ((n + 1) / 5 == 2) ten :: Nil
      else List()
    }

    if (n % 5 == 4) one :: s
    else s ::: List.fill(n % 5)(one)
  }

  private def r1(n: Int): List[Char] = convert(n)('I', 'V', 'X')

  private def r10(n: Int): List[Char] = convert(n / 10)('X', 'L', 'C')

  private def r100(n: Int): List[Char] = convert(n / 100)('C', 'D', 'M')

  private def r1000(n: Int): List[Char] = convert(n / 1000)('M')

}
