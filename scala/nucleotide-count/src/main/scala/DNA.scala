/**
  *
  * @author Cedric Zhuang
  *
  */
class DNA(dna: String) {
  private def findInvalid(seq: String = dna): Option[Char] =
    seq.find(!"ACTG".contains(_))

  private def getError(s: Char): Either[String, Nothing] =
    Left(f"invalid nucleotide '$s'")

  def count(c: Char): Either[String, Int] =
    findInvalid(c.toString).map(getError)
      .getOrElse(nucleotideCounts.right.map(x => x(c)))

  def nucleotideCounts: Either[String, Map[Char, Int]] =
    findInvalid().map(getError)
      .getOrElse(Right("ACTG".map(s => (s, dna.count(_ == s))).toMap))
}
