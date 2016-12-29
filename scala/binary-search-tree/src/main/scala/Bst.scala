/**
  *
  * @author Cedric Zhuang
  *
  */
case class Bst[T: Ordering](value: T,
                            left: Option[Bst[T]] = None,
                            right: Option[Bst[T]] = None) {
  def insert(v: T): Bst[T] =
    if (implicitly[Ordering[T]].lteq(v, value))
      copy(left = left.map(_.insert(v)).orElse(Some(Bst(v))))
    else
      copy(right = right.map(_.insert(v)).orElse(Some(Bst(v))))
}

object Bst {
  def fromList[T: Ordering](li: List[T]): Bst[T] = {
    require(li.nonEmpty)
    li.tail.foldLeft(Bst(li.head))(_ insert _)
  }

  def toList[T](bst: Bst[T]): List[T] = toList(Some(bst))

  private def toList[T](bst: Option[Bst[T]]): List[T] =
    bst.map(b => toList(b.left) ++ List(b.value) ++ toList(b.right))
      .orElse(Option(Nil)).get

}
