object CryptoSquare {
  def normalizePlaintext(text: String): String =
    text.toLowerCase.filter(_.isLetterOrDigit).mkString

  def squareSize(text: String): Int = math.sqrt(text.length).ceil.toInt

  def plaintextSegments(text: String): List[String] = {
    val normalized = normalizePlaintext(text)
    normalized.grouped(squareSize(normalized)).toList
  }

  def ciphertext(text: String, sep: String = ""): String = {
    if (text.trim.length == 0) return ""

    val li = plaintextSegments(text)
    (0 until li.head.length).map(
      i => li.map(
        j => j.applyOrElse(i, (_:Int) => ' '))
        .mkString.trim)
      .mkString(sep)
  }

  def normalizedCiphertext(text: String): String = ciphertext(text, " ")
}
