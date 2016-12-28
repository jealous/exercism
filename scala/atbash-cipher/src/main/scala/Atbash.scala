object Atbash {
  private val dict: Map[Char, Char] =
    ('a' to 'z').zip(('a' to 'z').reverse).toMap

  def encode(s: String): String = {
    val normalizedText: String = s.toLowerCase.filter(_.isLetterOrDigit)
    normalizedText.map(c => dict.getOrElse(c, c)).grouped(5).mkString(" ")
  }

}
