package toyotaSystems2021

object AOnandOff extends App {
  val stxVector = scala.io.StdIn.readLine().split(" ").map(_.toInt).toVector
  val s = stxVector(0)
  val t = stxVector(1)
  val x = stxVector(2)

  if (s == x && t ==x) {
    println("No")
  } else if (s <= x) {
    if (t >= x) {
      println("Yes")
    } else if (s > t) {
      println("Yes")
    } else {
      println("No")
    }
  } else {
    if (t > x) {
      println("Yes")
    } else {
      println("No")
    }
  }
}
