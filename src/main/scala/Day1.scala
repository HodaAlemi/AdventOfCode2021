

object Day1 extends App {

  val stream = getClass.getResourceAsStream("/day1.txt")
  val inputLines: Iterator[String] = scala.io.Source.fromInputStream(stream).getLines
  val numbersList: List[Int] = inputLines.map(line => line.trim.toInt).toList

  def isSecondValueBiggerThanFirst(numbers: List[Int]) : List[Boolean] ={
    numbers.sliding(2).map{ case Seq(x, y) => y > x }.toList
  }

  /** Part 1 */
  val compareNumbers = isSecondValueBiggerThanFirst(numbersList)
  val filterTrueValues = compareNumbers.filter(_.equals(true))
  println("How many measurements are larger than the previous sum? " + filterTrueValues.size)


  /** Part 2 */
  val threeMeasurementSum= numbersList.sliding(3).map{ case Seq(x, y, z) => x + y + z }.toList
  val compareNumbersThreeMeasurementSum = isSecondValueBiggerThanFirst(threeMeasurementSum)
  val filterTrueValuesThreeMeasurementSum = compareNumbersThreeMeasurementSum.filter(_.equals(true))
  println("How many sums are larger than the previous sum? " + filterTrueValuesThreeMeasurementSum.size)

}
