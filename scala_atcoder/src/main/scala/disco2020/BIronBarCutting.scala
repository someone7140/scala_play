package disco2020

// https://atcoder.jp/contests/ddcc2020-qual/tasks/ddcc2020_qual_b

import scala.util.control.Breaks

object BIronBarCutting extends App {
  val n = scala.io.StdIn.readInt()
  val a = scala.io.StdIn.readLine()
  val aArray = a.split(" ").map(_.toLong).toVector
  val sum = aArray.sum
  val sumCenter = aArray.sum / 2L

  var index = 0L
  var lowerSum = 0L
  var result = 0L

  val b = new Breaks
  b.breakable {
    (0 to n - 1).foreach { i =>
      val tempSum = lowerSum + aArray(i)
      if (tempSum > sumCenter) {
        val lower = (sum - lowerSum) - lowerSum
        val upper = tempSum - (sum - tempSum)
        if (lower < upper) {
          result = lower
        } else {
          result = upper
        }
        b.break()
      } else {
        lowerSum = tempSum
      }
    }
  }
  println(result)

}
