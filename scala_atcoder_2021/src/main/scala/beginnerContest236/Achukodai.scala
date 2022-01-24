package beginnerContest236

object Achukodai extends App {
  val s = scala.io.StdIn.readLine()
  val abVector = scala.io.StdIn.readLine().split(" ").map(_.toInt).toVector
  val a = abVector(0) - 1
  val b = abVector(1) - 1

  val charString = s.toCharArray.map(c => c.toString)
  val afterCharString = charString.clone()
  afterCharString(a) = charString(b)
  afterCharString(b) = charString(a)

  println(afterCharString.mkString)

}
