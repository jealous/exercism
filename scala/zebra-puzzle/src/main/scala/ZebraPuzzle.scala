object ZebraPuzzle extends Enumeration {
  type Resident = Value
  val Englishman, Spaniard, Ukrainian, Norwegian, Japanese, Unknown = Value

  case class Solution(waterDrinker: Resident, zebraOwner: Resident)

  private def p: Iterator[Seq[Int]] = (0 to 4).permutations

  private def isRightTo(x: Int, y: Int): Boolean = x - y == 1

  private def nextTo(x: Int, y: Int): Boolean = math.abs(x - y) == 1

  private val Seq(first: Int, _, middle: Int, _, _) = 0 to 4

  lazy val solve: Solution = solutions.next()

  private def solutions: Iterator[Solution] =
    for (residents <- p;

         Seq(englishman: Int, spaniard: Int, ukrainian: Int,
         norwegian: Int, japanese: Int) <- Seq(residents)
         if norwegian == first;

         Seq(red: Int, blue: Int, green: Int, ivory: Int, yellow) <- p
         if englishman == red
           && isRightTo(green, ivory)
           && nextTo(norwegian, blue);

         Seq(dog: Int, snail: Int, zebra: Int, fox: Int, horse: Int) <- p
         if spaniard == dog;

         Seq(coffee, tea: Int, milk: Int, orangeJuice: Int, water: Int) <- p
         if green == coffee
           && tea == ukrainian
           && milk == middle;

         Seq(oldGold: Int, kools: Int, chesterfields: Int,
         luckyStrike: Int, parliaments: Int) <- p
         if oldGold == snail
           && kools == yellow
           && nextTo(chesterfields, fox)
           && nextTo(kools, horse)
           && luckyStrike == orangeJuice
           && japanese == parliaments)

      yield Solution(
        getResident(water, residents),
        getResident(zebra, residents))

  private def getResident(house: Int, residents: Seq[Int]) =
    ZebraPuzzle(residents.zipWithIndex.find { case (v, _) => v == house }.get._2)
}

