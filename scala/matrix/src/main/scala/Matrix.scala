/**
  *
  * @author Cedric Zhuang
  *
  */
case class Matrix(repr: String) {
  lazy val rows: Vector[Vector[Int]] =
    repr.split("\n").map(_.split(" ").map(_.toInt).toVector).toVector

  lazy val cols: Vector[Vector[Int]] = rows.transpose.map(_.toVector)
}
