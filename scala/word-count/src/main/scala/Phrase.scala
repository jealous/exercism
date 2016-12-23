/**
  *
  * @author Cedric Zhuang
  *
  */
class Phrase(text: String) {
  val words = text.toLowerCase.split("""[^'\w]+""")
  def wordCount = words.groupBy(identity).mapValues(_.length)
}
