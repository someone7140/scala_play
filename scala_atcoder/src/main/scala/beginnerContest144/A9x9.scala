package beginnerContest144

// https://atcoder.jp/contests/abc144/tasks/abc144_a

object A9x9 extends App {
  val ab = scala.io.StdIn.readLine()
  val abArray = ab.split(" ").map(_.toInt).toVector
  val a = abArray(0)
  val b = abArray(1)
  if (a >= 10 || b >= 10) {
    println(-1)
  } else {
    println(a * b)
  }
}
