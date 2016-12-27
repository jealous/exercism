object PrimeFactors {
  def forNumber(n: Long, factor: Int = 2): List[Int] =
    if (n <= 1) {
      Nil
    } else if (n % factor == 0) {
      factor :: forNumber(n / factor, factor)
    } else {
      forNumber(n, factor + 1)
    }
}
