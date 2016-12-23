/**
  *
  * @author Cedric Zhuang
  *
  */
case class Year(year: Int) {
  lazy val isLeap: Boolean =
    year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
}

