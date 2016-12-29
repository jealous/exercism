/**
  *
  * @author Cedric Zhuang
  *
  */
object Brackets {
  private val left = "{[("
  private val right = "}])"
  private val dict = (right zip left).toMap

  def areBalanced(inputs: String): Boolean =
    inputs.foldLeft(List[Char]('S'))((li, char) => char match {
      case c if left.contains(c) => c :: li
      case c if right.contains(c) =>
        if (li.head == dict(c)) li.tail
        else 'X' :: li
      case _ => li
    }) == List('S')
}
