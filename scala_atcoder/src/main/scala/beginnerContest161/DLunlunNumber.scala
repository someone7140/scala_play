package beginnerContest161

// https://atcoder.jp/contests/abc161/tasks/abc161_d

import scala.util.control.Breaks

object DLunlunNumber extends App {
  val k =  scala.io.StdIn.readInt()
  var result = 0L
  (1 to k).foreach { _=>
    val b = new Breaks
    b.breakable {
      var temp = result
      while(true) {
        temp = temp + 1L
        val b2 = new Breaks
        var tempJudge =  temp.toString.head.toString.toInt
        var judge = true
        b2.breakable {
          temp.toString.foreach { s =>
            if (Math.abs(tempJudge - s.toString.toInt) > 1) {
              judge = false
              b2.break()
            } else {
              tempJudge = s.toString.toInt
            }
          }
        }
        if(judge) {
          result = temp
          b.break()
        }
      }
    }
  }
  println(result)

}
