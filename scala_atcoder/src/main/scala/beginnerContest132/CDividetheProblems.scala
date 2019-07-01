package beginnerContest132

// https://atcoder.jp/contests/abc132/tasks/abc132_c

object CDividetheProblems extends App {
  val n = scala.io.StdIn.readInt()
  val read = scala.io.StdIn.readLine()
  val d =  read.split(" ").map(_.toInt).toVector.sorted
  val half = d.size / 2
  val before = d(half - 1)
  val after = d(half)
  println(after - before)
}