package beginnerContest161

// https://atcoder.jp/contests/abc161/tasks/abc161_a

object AABCSwap extends App {
  val xyz =  scala.io.StdIn.readLine()
  val xyzArray = xyz.split(" ").map(_.toInt).toSeq

  println(xyzArray(2) + " " + xyzArray(0) + " " + xyzArray(1))
}
