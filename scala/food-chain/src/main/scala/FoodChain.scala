/**
  *
  * @author Cedric Zhuang
  *
  */
object FoodChain {
  private val animals: Array[String] =
    "fly spider bird cat dog goat cow horse".split(" ")

  private def first(p: Int): String =
    s"I know an old lady who swallowed a ${animals(p - 1)}.\n"

  private def second(p: Int): String = p match {
    case 2 => "It wriggled and jiggled and tickled inside her.\n"
    case 3 => "How absurd to swallow a bird!\n"
    case 4 => "Imagine that, to swallow a cat!\n"
    case 5 => "What a hog, to swallow a dog!\n"
    case 6 => "Just opened her throat and swallowed a goat!\n"
    case 7 => "I don't know how she swallowed a cow!\n"
    case _ => ""
  }

  private def getPrey(i: Int): String =
    if (i == 1) "spider that wriggled and jiggled and tickled inside her"
    else animals(i)

  private def middle(p: Int): String =
    if (p == 8) ""
    else (p - 1).to(1, -1)
      .map(i => s"She swallowed the ${animals(i)} to catch the ${getPrey(i - 1)}.\n")
      .mkString

  private def last(p: Int): String =
    if (p == 8) "She's dead, of course!\n\n"
    else "I don't know why she swallowed the fly. Perhaps she'll die.\n"

  private def verse(p: Int): String =
    List(first(p), second(p), middle(p), last(p)).mkString

  def song: String = (1 to 8).map(verse).mkString("\n")
}
