/**
  *
  * @author Cedric Zhuang
  *
  */
class Scrabble {
  private val rawScoreMap: Map[String, Int] = Map(
    "aeioulnrst" -> 1,
    "dg" -> 2,
    "bcmp" -> 3,
    "fhvwy" -> 4,
    "k" -> 5,
    "jx" -> 8,
    "qz" -> 10)

  private lazy val scoreMap: Map[Char, Int] =
    rawScoreMap.flatMap { case (s, v) => s.map(_ -> v) }

  def scoreLetter(c: Char): Int = scoreMap(c.toLower)

  def scoreWord(word: String): Int = word.map(scoreLetter).sum
}
