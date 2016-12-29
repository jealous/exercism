object Queens {
  private def line = List.fill(8)('_').mkString(" ") + "\n"

  implicit def strToBoard(str: String): Board = Board(str)

  def boardString(white: Option[Position], black: Option[Position]): String =
    Board(List.fill(8)(line).mkString)
      .place('W', white)
      .place('B', black)

  def canAttack(white: Position, black: Position): Boolean =
    white.sameRow(black) ||
      white.sameColumn(black) ||
      white.sameDiagonal(black)
}

case class Board(str: String) {
  def place(chess: Char, pos: Option[Position]): String =
    pos match {
      case Some(p: Position) => str.take(p.pos) + chess.toString + str.drop(p.pos + 1)
      case _ => str
    }
}

case class Position(x: Int, y: Int) {
  lazy val pos: Int = 16 * x + 2 * y

  def sameRow(other: Position): Boolean = x == other.x

  def sameColumn(other: Position): Boolean = y == other.y

  def sameDiagonal(other: Position): Boolean =
    math.abs(x - other.x) == math.abs(y - other.y)
}
