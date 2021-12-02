
object Day2 extends App {
  val stream = getClass.getResourceAsStream("/day2.txt")
  val inputLines: Iterator[String] = scala.io.Source.fromInputStream(stream).getLines

  val tuplesList: List[(String, Int)] = inputLines.map{
    line =>
      val splittedLine: List[String] = line.trim.split(" ").toList
      (splittedLine(0), splittedLine(1).toInt)
  }.toList

  /** Part 1 */

  var position = 0
  var depth = 0

  tuplesList.foreach {
    case ("forward", value) => position = position + value
    case ("up", value) => depth = depth - value
    case ("down", value) => depth =  depth + value
  }

  println("position * depth: " + position * depth)

  /** Part 2 */
  position = 0
  depth = 0
  var aim = 0
  println("resetting position & depth, " + "position is: " + position + "  & depth is: " + depth)

  tuplesList.foreach {
    case ("forward", value) =>
      position = position + value
      depth = depth + (aim * value)
    case ("up", value) => aim = aim - value
    case ("down", value) => aim =  aim + value
  }

  println("position * depth: " + position * depth )

}
