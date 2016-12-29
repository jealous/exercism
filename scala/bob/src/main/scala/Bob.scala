/**
  *
  * @author Cedric Zhuang
  *
  */
class Bob {
  def hey(q: String) = q.trim match {
    case s if s.isEmpty => "Fine. Be that way!"
    case s if s.toUpperCase == s && s.exists(_.isLetter) => "Whoa, chill out!"
    case s if s.endsWith("?") => "Sure."
    case _ => "Whatever."
  }
}
