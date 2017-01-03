/**
  *
  * @author Cedric Zhuang
  *
  */


case class Deque[T]() {

  case class Node(value: T,
                  var prev: Option[Node] = None,
                  var next: Option[Node] = None)

  private var head: Option[Node] = None
  private var tail: Option[Node] = None

  def push(v: T): Unit = {
    val node = Some(Node(v, tail))
    if (head.isEmpty) head = node
    tail.foreach(_.next = node)
    tail = node
  }

  def pop: Option[T] = tail map { t =>
    val ret: T = t.value
    tail = t.prev
    tail.foreach(_.next = None)
    ret
  } orElse None

  def shift: Option[T] = head map { h =>
    val ret: T = h.value
    head = h.next
    head.foreach(_.prev = None)
    ret
  } orElse None

  def unshift(v: T): Unit = {
    val node = Some(Node(v, next = head))
    if (tail.isEmpty) tail = node
    head.foreach(_.prev = node)
    head = node
  }
}
