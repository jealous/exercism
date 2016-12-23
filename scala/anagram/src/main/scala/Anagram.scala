/**
  *
  * @author Cedric Zhuang
  *
  */
class Anagram(p: String) {
  lazy val lp = p.toLowerCase.sorted

  def matches(words: Seq[String]): Seq[String] = {
    words.filter(word => {
      val wordLower = word.toLowerCase
      wordLower.sorted == lp && wordLower != p
    })
  }
}
