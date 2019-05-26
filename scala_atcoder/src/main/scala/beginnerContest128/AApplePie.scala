package beginnerContest128

// https://atcoder.jp/contests/abc128/tasks/abc128_a

object AApplePie extends App {
  val read = scala.io.StdIn.readLine()
  val array =  read.split(" ").map(_.toInt).toVector
  val a = array(0)
  val p = array(1)
  println((a * 3 + p) / 2)
}
