import scala.annotation.tailrec
import scala.util.Random

/**
  *
  * @author Cedric Zhuang
  *
  */
class Robot {
  private val chars: Array[Char] = ('A' to 'Z').toArray
  private val numbers: Array[Char] = ('0' to '9').toArray

  var name: String = nameGen

  def reset(): Unit = name = nameGen

  private def randChar: Char = chars(Random.nextInt(chars.length))

  private def randInt: Char = numbers(Random.nextInt(numbers.length))

  @tailrec
  private def nameGen: String = {
    val ret: String = s"$randChar$randChar$randInt$randInt$randInt"
    if (Robot.usedNames.contains(ret))
      nameGen
    else {
      Robot.usedNames += ret
      ret
    }
  }
}

object Robot {
  private var usedNames: Set[String] = Set.empty
}
