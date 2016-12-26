/**
  *
  * @author Cedric Zhuang
  *
  */
object ETL {
  def transform(old: Map[Int, Seq[String]]): Map[String, Int] =
    old.flatMap { case (k, vs) => vs.map(_.toLowerCase -> k) }
}
