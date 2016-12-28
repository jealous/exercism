import scala.annotation.tailrec

/**
  *
  * @author Cedric Zhuang
  *
  */
object AllYourBase {
  @tailrec
  private def toBase(value: Int, base: Int, result: List[Int]): List[Int] =
    if (value < base) value :: result
    else toBase(value / base, base, value % base :: result)

  private def invalidBase(bases: Int*): Boolean = !bases.forall(_ > 1)

  private def invalidNumber(b: Int, numbers: List[Int]): Boolean =
    numbers.exists(v => v < 0 || v >= b)

  private def isEmpty(numbers: List[Int]): Boolean =
    numbers == Nil || numbers.toSet == Set(0)

  def rebase(f: Int, numbers: List[Int], t: Int): Option[List[Int]] =
    if (invalidBase(f, t) || invalidNumber(f, numbers)) None
    else if (isEmpty(numbers)) Some(Nil)
    else Some(toBase(numbers.reduce((p, v) => p * f + v), t, Nil))
}
