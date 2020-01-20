package beginnerContest152

// https://atcoder.jp/contests/abc152/tasks/abc152_b

object BComparingStrings extends App {
  val abInput = scala.io.StdIn.readLine()
  val abArray = abInput.split(" ").map(_.toInt).toSeq
  val display = if (abArray(0) > abArray(1)) abArray(1) else abArray(0)
  val repeat = if (abArray(0) > abArray(1)) abArray(0) else abArray(1)
  var result = ""
  (1 to repeat).foreach(_ => result = result + display.toString)
  println(result)
}
