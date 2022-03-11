package beginnerContest242

object BMinimizeOrdering extends App {
  val s = scala.io.StdIn.readLine()
  val result = s.toCharArray.sorted.map(_.toString).mkString
  println(result)
}
