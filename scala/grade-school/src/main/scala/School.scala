import scala.collection.immutable.SortedMap

/**
  *
  * @author Cedric Zhuang
  *
  */
class School {
  private var _db: Map[Int, Seq[String]] = SortedMap()

  def db: Map[Int, Seq[String]] = _db

  def add(n: String, g: Int): Unit = _db += (g -> (grade(g) :+ n))

  def grade(g: Int): Seq[String] = _db.getOrElse(g, Seq())

  def sorted: Map[Int, Seq[String]] = _db.mapValues(_.sorted)
}
