package beginnerContest129

// https://atcoder.jp/contests/abc129/tasks/abc129_a

object AApplePie extends App {
  val read = scala.io.StdIn.readLine()
  val array =  read.split(" ").map(_.toInt).toVector.sorted
  println(array(0) + array(1))
}
