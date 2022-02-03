package beginnerContest237

import scala.util.control.Breaks

object Ckasaka extends App {
  val s = scala.io.StdIn.readLine()
  val sLength = s.length
  var tempSLength = sLength

  var sArray = s.toCharArray.map(c => c.toString)
  var result = "Yes"
  val b1 = new Breaks
  var beforeIndexMinus = 0
  var beforeIndex = -1
  var afterIndex = -1
  var aAppendFlag = true

  b1.breakable {
    (0 to sLength - 1).foreach(i => {
      if (i >= tempSLength / 2) {
        b1.break()
      }
      beforeIndex = i - beforeIndexMinus
      afterIndex = sLength - 1 - i
      val before = sArray(beforeIndex)
      val after = sArray(afterIndex)
      if (before != after) {
        if (after =="a" && aAppendFlag) {
          beforeIndexMinus = beforeIndexMinus + 1
          tempSLength = tempSLength + 1
        } else {
          result = "No"
          b1.break()
        }
      }
    })
  }
  println(result)
}
