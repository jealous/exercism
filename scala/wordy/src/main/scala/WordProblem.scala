import scala.util.Try

/**
  *
  * @author Cedric Zhuang
  *
  */
case class State(v: Int = 0, op: String = "none") {
  private val ops: Map[String, (Int, Int) => Int] = Map(
    "plus" -> (_ + _),
    "minus" -> (_ - _),
    "multiplied" -> (_ * _),
    "divided" -> (_ / _),
    "raised" -> (math.pow(_, _).toInt))

  def calc(word: String): State =
    if (ops.keySet.contains(word)) State(v, word)
    else if (word.forall(c => c.isDigit || c == '-'))
      if (op == "none") this.copy(v = word.toInt)
      else this.copy(v = ops(op)(v, word.toInt))
    else this.copy()
}

object WordProblem {
  def apply(q: String): Option[Int] =
    Try(q.stripSuffix("?").split(" +")
      .foldLeft(State()) { case (s, word) => s.calc(word) }.v).toOption
}
