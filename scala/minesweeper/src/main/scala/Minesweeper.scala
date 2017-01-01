import scala.collection.mutable
import scala.util.Try

/**
  *
  * @author Cedric Zhuang
  *
  */
object Minesweeper {
  def neighbours(i: Int, j: Int): Seq[(Int, Int)] =
    for (x <- i - 1 to i + 1;
         y <- j - 1 to j + 1)
      yield (x, y)

  def annotate(board: List[String]): List[String] = {
    val mb = mutable.IndexedSeq(board.map(new StringBuilder(_)): _*)

    def plusOne(i: Int, j: Int): Unit =
      Try(mb(i)(j)).map { v: Char =>
        if (v == ' ') mb(i)(j) = '1'
        else if (v != '*') mb(i)(j) = (mb(i)(j) + 1).toChar
      }

    for (i <- mb.indices;
         j <- mb(i).indices) {
      if (mb(i)(j) == '*')
        neighbours(i, j).foreach { case (x: Int, y: Int) => plusOne(x, y) }
    }
    mb.map(_.toString).toList
  }
}
