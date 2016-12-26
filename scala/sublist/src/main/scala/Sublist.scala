import scala.annotation.tailrec

/**
  *
  * @author Cedric Zhuang
  *
  */
object Sublist extends Enumeration {
  type Rel = Value
  val Equal, Unequal, Sublist, Superlist = Value

  private def check(l1: List[Any], l2: List[Any]): Boolean = {
    @tailrec
    def loop(c1: List[Any], c2: List[Any], rest: List[Any]): Boolean =
      if (c2 == Nil) true
      else if (c1 == Nil) c2 == Nil
      else if (c1.head == c2.head) loop(c1.tail, c2.tail, rest)
      else loop(rest.tail, l2, rest.tail)

    loop(l1, l2, l1)
  }

  def sublist(l1: List[Any], l2: List[Any]): Rel =
    if (l1 == l2) Equal
    else if (l1.length > l2.length && check(l1, l2)) Superlist
    else if (l1.length < l2.length && check(l2, l1)) Sublist
    else Unequal
}
