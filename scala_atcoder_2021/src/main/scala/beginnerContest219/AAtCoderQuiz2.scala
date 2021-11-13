package beginnerContest219

object AAtCoderQuiz2 extends App {
  val x = scala.io.StdIn.readInt()

  if (x >= 90) {
    println("expert")
  } else if (x >= 70 && x < 90) {
    println(90 - x)
  } else if (x >= 40 && x < 70) {
    println(70 - x)
  } else {
    println(40 - x)
  }
}
