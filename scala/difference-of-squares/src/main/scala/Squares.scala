/**
  *
  * @author Cedric Zhuang
  *
  */
object Squares {
  private def sqr(x: Int): Int = x * x

  def sumOfSquares(n: Int): Int = (1 to n).map(sqr).sum

  def squareOfSums(n: Int): Int = sqr((1 to n).sum)

  def difference(n: Int): Int = squareOfSums(n) - sumOfSquares(n)
}
