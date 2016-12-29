/**
  *
  * @author Cedric Zhuang
  *
  */
object SumOfMultiples {
  def sumOfMultiples(ls: List[Int], limit: Int): Int ={
    ls.flatMap { n => n until limit by n }.toSet.sum
  }
}
