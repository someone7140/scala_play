package beginnerContest158

// https://atcoder.jp/contests/abc158/tasks/abc158_c

import scala.util.control.Breaks

object CTaxIncrease extends App {
  val abInput = scala.io.StdIn.readLine()
  val abArray = abInput.split(" ").map(_.toInt).toSeq
  val a = abArray(0)
  val b = abArray(1)
  val break = new Breaks

  var result = -1
  break.breakable {
    (10 to 10000).foreach { i =>
      val aResult = (i * 0.08).toInt
      val bResult = (i * 0.1).toInt

      if(a == aResult && b == bResult) {
        result = i
        break.break()
      }
    }
  }
  println(result)
}
