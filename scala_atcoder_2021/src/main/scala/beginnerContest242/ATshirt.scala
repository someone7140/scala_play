package beginnerContest242

object ATshirt extends App {
  val abcxVector = scala.io.StdIn.readLine().split(" ").map(_.toDouble).toVector
  val a = abcxVector(0)
  val b = abcxVector(1)
  val c = abcxVector(2)
  val x = abcxVector(3)

  if (x <= a) {
    println(1d)
  } else if (x <= b) {
    println(c / (b - a))
  } else {
    println(0d)
  }
}
