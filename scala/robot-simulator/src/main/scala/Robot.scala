

/**
  *
  * @author Cedric Zhuang
  *
  */
case class Robot(bearing: Bearing.Direction, cord: (Int, Int)) {
  private val (x, y) = coordinates

  def coordinates: (Int, Int) = cord

  def advance(): Robot =
    bearing match {
      case Bearing.East => copy(cord = (x + 1, y))
      case Bearing.South => copy(cord = (x, y - 1))
      case Bearing.West => copy(cord = (x - 1, y))
      case Bearing.North => copy(cord = (x, y + 1))
    }

  def turnRight(): Robot =
    Robot(Bearing((bearing.id + 1) % 4), (x, y))

  def turnLeft(): Robot =
    Robot(Bearing((bearing.id + 4 - 1) % 4), (x, y))

  def simulate(cmd: String): Robot =
    cmd.foldLeft(this)((r: Robot, c: Char) => c match {
      case 'A' => r.advance()
      case 'L' => r.turnLeft()
      case 'R' => r.turnRight()
    })
}

object Bearing extends Enumeration {
  type Direction = Value
  val East, South, West, North = Value
}
