/**
  *
  * @author Cedric Zhuang
  *
  */
class Garden(names: List[String], plants: String) {
  private lazy val plantsByName: List[String] = {
    val rows = plants.split("\n").map(_.grouped(2).toList)
    rows(0).zip(rows(1)).map { case (x, y) => x + y }
  }

  def getPlants(name: String): List[Plant.Plants] = {
    val plantsStr: String = plantsByName.applyOrElse(
      names.indexOf(name), (_:Int) => "")
    Plant.getPlants(plantsStr)
  }
}


object Garden extends Enumeration {
  private val defaultNames: List[String] = List(
    "Alice", "Bob", "Charlie", "David",
    "Eve", "Fred", "Ginny", "Harriet",
    "Ileana", "Joseph", "Kincaid", "Larry")

  def defaultGarden(plants: String): Garden =
    apply(defaultNames, plants)

  def apply(names: List[String], plants: String): Garden =
    new Garden(names.sorted, plants)
}


object Plant extends Enumeration {
  type Plants = Value
  val Violets, Clover, Radishes, Grass = Value

  private lazy val dict: Map[Char, Plants] =
    "VCRG".zip(this.values).toMap

  def getPlants(str: String): List[Plants] = str.map(dict).toList
}