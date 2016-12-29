import scala.util.Try

/**
  *
  * @author Cedric Zhuang
  *
  */
object House {
  private lazy val actions: List[String] =
    """lay in the house that Jack built.
      |ate the malt
      |killed the rat
      |worried the cat
      |tossed the dog
      |milked the cow with the crumpled horn
      |kissed the maiden all forlorn
      |married the man all tattered and torn
      |woke the priest all shaven and shorn
      |kept the rooster that crowed in the morn
      |belonged to the farmer sowing his corn
      |is the horse and the hound and the horn"""
      .stripMargin.split("\n").toList

  private lazy val items: List[String] =
    actions.map(s => s.drop(s.indexOf("the") + 4))

  def chapter(n: Int): List[String] =
    ("This is the " + items(n - 1)) ::
      Try(actions.take(n).reverse.tail.map("that " + _)).getOrElse(Nil)

  def rhyme: String =
    (1 to 12).map(chapter(_).mkString("\n") + "\n\n").mkString
}
