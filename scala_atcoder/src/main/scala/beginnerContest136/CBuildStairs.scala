package beginnerContest136

import scala.util.control.Breaks

// https://atcoder.jp/contests/abc136/tasks/abc136_c

object CBuildStairs extends App {
  val n = scala.io.StdIn.readInt()
  val read = scala.io.StdIn.readLine()
  val array =  read.split(" ").map(_.toInt).toVector

  var result = "Yes"
  val b = new Breaks
  val lastIndex = n - 1

  var beforeTempH = 0
  var beforeDiff = 0
  var afterDiff = 0

  b.breakable{
    array.zipWithIndex.foreach { case(h, i) =>
      var tempH = h
      var minusflg = false
      if( i != 0) {
        beforeDiff = h - beforeTempH
        if (beforeDiff > 2 || beforeDiff < 0) {
          result = "No"
          b.break()
        } else if(beforeDiff == 2) {
          tempH = h - 1
          minusflg = true
        }
      }
      if(i != lastIndex) {
        afterDiff = array(i + 1) - tempH
        if(afterDiff > 2 || afterDiff < -1) {
          result = "No"
          b.break()
        } else if(afterDiff == -1) {
          if(minusflg || (i !=0 && beforeDiff < 1)) {
            result = "No"
            b.break()
          } else {
            tempH = h - 1
          }
        }
      }
      beforeTempH = tempH
    }
  }
  println(result)

}
