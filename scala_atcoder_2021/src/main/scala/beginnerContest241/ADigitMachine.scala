package beginnerContest241

object ADigitMachine extends App {
  val aVector = scala.io.StdIn.readLine().split(" ").map(_.toInt).toVector
  val a1 = aVector(0)
  val a2 = aVector(a1)
  val a3 = aVector(a2)

  println(a3)
}
