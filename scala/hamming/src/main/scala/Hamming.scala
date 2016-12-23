/**
  *
  * @author Cedric Zhuang
  *
  */
object Hamming {
  def compute(s1: String, s2: String): Option[Int] = {
    if (s1.length != s2.length) return None
    Some(s1.zip(s2).count { case (a, b) => a != b })
  }

}
