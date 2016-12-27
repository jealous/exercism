/**
  *
  * @author Cedric Zhuang
  *
  */
case class Triangle(a: Int, b: Int, c: Int) {

  import TriangleType._

  lazy val triangleType: TriangleType.Value =
    if (!isLogical) Illogical
    else if (isEquilateral) Equilateral
    else if (isIsosceles) Isosceles
    else Scalene

  lazy val isIsosceles: Boolean = a == b || b == c || a == c
  lazy val isEquilateral: Boolean = a == b && b == c
  lazy val isLogical: Boolean = a + b > c && b + c > a && c + a > b
}

object TriangleType extends Enumeration {
  val Equilateral, Isosceles, Scalene, Illogical = Value
}
