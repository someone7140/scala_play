package beginnerContest170

// https://atcoder.jp/contests/abc170/tasks/abc170_d

import scala.util.control.Breaks

object DNotDivisible extends App {
  val n = scala.io.StdIn.readInt()
  val aInput = scala.io.StdIn.readLine()
  val aArray =  aInput.split(" ").map(_.toInt).toVector.sorted

  var result = 0

  aArray.zipWithIndex.foreach { a =>
    val b = new Breaks
    b.breakable {
      (0 to n - 1).foreach { i =>
        if (a._2 != i) {
          val bunbo = aArray(i)
          if (a._1 < bunbo) {
            b.break()
          } else if (a._1 % bunbo == 0) {
            result = result + 1
            b.break()
          } else if (a._1 / 2 + 1 < bunbo) {
            b.break()
          }
        }
      }
    }
  }
  println(n - result)

}
