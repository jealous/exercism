import scala.annotation.tailrec

/**
  *
  * @author Cedric Zhuang
  *
  */
class Accumulate {
  def accumulate[X, Y](func: X => Y, inputList: List[X]): List[Y] = {

    @tailrec
    def loop(s: List[X], t: List[Y]): List[Y] = {
      s match {
        case Nil => t.reverse
        case header :: tail => loop(tail, func(header) :: t)
      }
    }

    loop(inputList, Nil)
  }


}
