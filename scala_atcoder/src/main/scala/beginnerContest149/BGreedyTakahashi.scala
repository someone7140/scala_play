package beginnerContest149

// https://atcoder.jp/contests/abc149/tasks/abc149_b

object BGreedyTakahashi extends App {
  val abk = scala.io.StdIn.readLine()
  val abkArray = abk.split(" ").map(_.toLong).toVector
  val a = abkArray(0)
  val b = abkArray(1)
  val k = abkArray(2)
  if (a >= k) {
    println((a - k) + " " + b)
  } else if (a + b >= k) {
    println("0 " + (a + b - k))
  } else {
    println("0 0")
  }
}
