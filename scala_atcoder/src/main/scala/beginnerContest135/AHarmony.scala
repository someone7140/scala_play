package beginnerContest135

// https://atcoder.jp/contests/abc135/tasks/abc135_a

object AHarmony extends App {
  val read = scala.io.StdIn.readLine()
  val array =  read.split(" ").map(_.toInt).toVector
  val sum = array(0) + array(1)
  if (sum % 2 == 0) {
    println(sum / 2)
  } else {
    println("IMPOSSIBLE")
  }
}
