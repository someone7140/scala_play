package beginnerContest160

// https://atcoder.jp/contests/abc160/tasks/abc160_c

object CTravelingSalesmanaroundLake extends App {
  val knInput = scala.io.StdIn.readLine()
  val knArray = knInput.split(" ").map(_.toInt).toSeq
  val k = knArray(0)
  val n = knArray(1)

  val aInput = scala.io.StdIn.readLine()
  val aArray = aInput.split(" ").map(_.toInt).toVector

  val distance = aArray.zipWithIndex.map { a =>
    if (a._2 == 0) {
      a._1 + k - aArray(n - 1)
    } else {
      a._1 - aArray(a._2 - 1)
    }
  }
  val max = distance.max
  println(distance.sum - max)
}
