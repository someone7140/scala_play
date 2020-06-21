package tokyoKaijo2020

// https://atcoder.jp/contests/tokiomarine2020/tasks/tokiomarine2020_c

import scala.util.control.Breaks

object CLamps extends App {
  val nk =  scala.io.StdIn.readLine()
  val nkArray = nk.split(" ").map(_.toInt).toSeq
  val n = nkArray(0)
  val k = nkArray(1)

  val a =  scala.io.StdIn.readLine()
  val aArray = a.split(" ").map(_.toInt).toSeq
  var result = scala.collection.mutable.ListBuffer(aArray: _*)
  val maxResult = scala.collection.mutable.ListBuffer((1 to n).map(_ => n): _*)

  val b = new Breaks

  b.breakable {
    (1 to k).foreach { _ =>
      if(maxResult == result) {
        b.break()
      } else {
        val tempResult = scala.collection.mutable.ListBuffer((1 to n).map(_ => 0): _*)
        result.zipWithIndex.foreach { r =>
          val min = Math.ceil(r._2 - r._1 - 0.5).toInt
          val max = (r._2 + r._1 + 0.5).toInt
          (min to max).foreach { i =>
            if (i >= 0 && i < n) {
              val temp = tempResult(i)
              tempResult(i) = temp + 1
            }
          }
        }
        result = tempResult
      }
    }
  }
  println(result.mkString(" "))
}
