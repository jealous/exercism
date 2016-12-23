/**
  *
  * @author Cedric Zhuang
  *
  */
object Pangrams {
  def isPangram(s: String): Boolean =
    ('a' to 'z').forall(s.toLowerCase.contains(_))
}
