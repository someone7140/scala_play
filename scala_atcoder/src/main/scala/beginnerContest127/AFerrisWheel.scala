package beginnerContest127

// https://atcoder.jp/contests/abc127/tasks/abc127_a

object AFerrisWheel extends App {
  val read = scala.io.StdIn.readLine()
  val array =  read.split(" ").map(_.toInt).toVector
  val a = array(0)
  val b = array(1)
  if (a >= 13) {
    println(b)
  } else if (a >= 6 && a <= 12) {
    println(b / 2)
  } else {
    println(0)
  }
}
