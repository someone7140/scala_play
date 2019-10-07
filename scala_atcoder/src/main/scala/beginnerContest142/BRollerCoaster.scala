package beginnerContest142

// https://atcoder.jp/contests/abc142/tasks/abc142_b

object BRollerCoaster extends App {
  val nk = scala.io.StdIn.readLine()
  val nkArray = nk.split(" ").map(_.toInt).toVector
  val k = nkArray(1)

  val h = scala.io.StdIn.readLine()
  val hArray = h.split(" ").map(_.toInt).toVector
  println(hArray.filter(_ >= k).size)
}
