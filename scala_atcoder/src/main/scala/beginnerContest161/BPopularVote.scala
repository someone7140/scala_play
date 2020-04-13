package beginnerContest161

// https://atcoder.jp/contests/abc161/tasks/abc161_b

import scala.util.control.Breaks

object BPopularVote extends App {
  val nm =  scala.io.StdIn.readLine()
  val nmArray = nm.split(" ").map(_.toInt).toSeq
  val n = nmArray(0)
  val m = nmArray(1)

  val aInput =  scala.io.StdIn.readLine()
  val aArray = aInput.split(" ").map(_.toInt).toVector.sorted.reverse
  val aSum = aArray.sum.toDouble
  var result = true

  val b = new Breaks
  b.breakable {
    (1 to m).foreach { i =>
      val target = aArray(i  - 1).toDouble
      val judge = aSum / (4 * m).toDouble
      if(target < judge) {
        result = false
        b.break()
      }
    }
  }
  println(if (result) "Yes" else "No")
}
