/**
  *
  * @author Cedric Zhuang
  *
  */
class PhoneNumber(raw: String) {

  lazy val number: Option[String] = {
    raw.filter(_.isDigit) match {
      case n if n.length == 10 => Some(n)
      case n if n.length == 11 && n.head == '1' => Some(n.tail)
      case _ => None
    }
  }

  lazy val prettyPrint: Option[String] =
    number.map(n => s"(${n.take(3)}) ${n.substring(3, 6)}-${n.takeRight(4)}")

  lazy val areaCode: Option[String] = number.map(_.take(3))
}
