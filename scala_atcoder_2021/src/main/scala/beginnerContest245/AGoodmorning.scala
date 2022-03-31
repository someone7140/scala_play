package beginnerContest245

object AGoodmorning extends App {
  val abcdArray = scala.io.StdIn.readLine().split(" ").map(_.toInt)
  val a = abcdArray(0)
  val b = abcdArray(1)
  val c = abcdArray(2)
  val d = abcdArray(3)

  if (a > c) {
    println("Aoki")
  } else if (a == c) {
    if(b > d) {
      println("Aoki")
    } else {
      println("Takahashi")
    }
  } else {
    println("Takahashi")
  }

}
