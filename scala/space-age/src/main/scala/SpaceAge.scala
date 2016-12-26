/**
  *
  * @author Cedric Zhuang
  *
  */
case class SpaceAge(seconds: Double) {
  lazy val earthYear: Double = seconds / 31557600
  lazy val onEarth: Double = round2(earthYear)
  lazy val onMercury: Double = round2(earthYear / 0.2408467)
  lazy val onVenus: Double = round2(earthYear / 0.61519726)
  lazy val onMars: Double = round2(earthYear / 1.8808158)
  lazy val onJupiter: Double = round2(earthYear / 11.862615)
  lazy val onSaturn: Double = round2(earthYear / 29.447498)
  lazy val onUranus: Double = round2(earthYear / 84.016846)
  lazy val onNeptune: Double = round2(earthYear / 164.79132)

  def round2(value: Double): Double =
    BigDecimal(value).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
}
