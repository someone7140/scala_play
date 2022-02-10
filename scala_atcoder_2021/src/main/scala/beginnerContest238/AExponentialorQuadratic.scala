package beginnerContest238

object AExponentialorQuadratic extends App {
  val n = scala.io.StdIn.readDouble()

  val n2jou = n * n
  val n2nojou = math.pow(2.0, n)
  if (n2jou < n2nojou) {
    println("Yes")
  } else {
    println("No")
  }

}
