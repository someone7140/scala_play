package beginnerContest170

// https://atcoder.jp/contests/abc170/tasks/abc170_a

object AFiveVariables extends App {
  val x =  scala.io.StdIn.readLine()
  val xArray = x.split(" ").map(_.toInt).toSeq
  val result = xArray.indexOf(0)
  println(result + 1)
}
