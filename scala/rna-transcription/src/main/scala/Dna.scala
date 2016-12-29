import scala.util.Try

/**
  *
  * @author Cedric Zhuang
  *
  */
object Dna {
  private val mapping = "GCTA".zip("CGAU").toMap

  def toRna(dna: String): Option[String] = Try(dna map mapping).toOption
}
