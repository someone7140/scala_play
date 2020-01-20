package beginnerContest152

// https://atcoder.jp/contests/abc152/tasks/abc152_d

import scala.util.control.Breaks

object DHandstand2 extends App {
  val n = scala.io.StdIn.readInt()
  var result = 0
  (1 to n).foreach { i =>
    val str = i.toString
    if (str.length == 1) {
      result = result + 1
      var tempStr = str
      val b = new Breaks
      b.breakable {
        while (true) {
          tempStr = tempStr + str
          val tempStrInt = tempStr.toInt
          if (tempStrInt <= n) {
            result = result + 1
          } else {
            b.break()
          }
        }
      }
    } else if (str.toCharArray.distinct.length == 1) {
      result = result + 1
      val addStr = str.charAt(0).toString
      var tempStr = ""
      val b = new Breaks
      b.breakable {
        while (true) {
          tempStr = addStr + str
          val tempStrInt = tempStr.toInt
          if (tempStrInt <= n) {
            result = result + 1
          } else {
            b.break()
          }
        }
      }
    } else {
      val middleStr = if (str.length > 3) str.substring(1, str.length -2) else ""
      val target = (str.charAt(str.length - 1).toString + middleStr + str.charAt(0).toString).toInt
      if (target <= n) {
        result = result + 1
      }
    }
  }
  println(result)
}
