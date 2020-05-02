package beginnerContest165

// https://atcoder.jp/contests/abc165/tasks/abc165_a

import scala.util.control.Breaks

object AWeLoveGolf extends App {
  val k =  scala.io.StdIn.readInt()
  val ab =  scala.io.StdIn.readLine()
  val abArray = ab.split(" ").map(_.toInt).toSeq
  val a = abArray(0)
  val b = abArray(1)
  var okFlg = false

  val break = new Breaks
  break.breakable {
    (a to b).foreach { i =>
      if (i % k == 0) {
        okFlg = true
        break.break()
      }
    }
  }
  if (okFlg) println("OK") else println("NG")
}
