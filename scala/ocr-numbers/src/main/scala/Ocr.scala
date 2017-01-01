/**
  *
  * @author Cedric Zhuang
  *
  */
case class Ocr(inputs: String) {
  private def splitDigits(inputs: Array[String]): Array[String] =
    inputs.map(_.grouped(3).toArray).transpose.map(_.mkString("\n"))

  private lazy val ocrMap: Map[String, Int] =
    splitDigits(
      """# _     _  _     _  _  _  _  _ 
         #| |  | _| _||_||_ |_   ||_||_|
         #|_|  ||_  _|  | _||_|  ||_| _|
         #                              """
        .stripMargin('#').split("\n")).zipWithIndex.toMap

  private def convertLine(line: Array[String]): String =
    splitDigits(line).map(ocrMap.getOrElse(_, "?")).mkString

  lazy val convert: String =
    inputs.split("\n").grouped(4).map(convertLine).mkString(",")
}
