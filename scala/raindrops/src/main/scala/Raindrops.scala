import scala.collection.SortedMap

object Raindrops {
  private val sound = SortedMap(
    3 -> "Pling",
    5 -> "Plang",
    7 -> "Plong"
  )

  def convert(n: Int): String = {
    val drops = sound.filterKeys(n % _ == 0).values.mkString
    if (drops.isEmpty) n.toString
    else drops
  }

}

