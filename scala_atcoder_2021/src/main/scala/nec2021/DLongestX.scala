package nec2021

object DLongestX extends App {
  val s = scala.io.StdIn.readLine()
  val k = scala.io.StdIn.readInt()
  val length = s.length
  val sCharArray = s.toCharArray

  var result = 0
  def sCount(index: Int, tempMax: Int, xCount: Int, xBefore: Boolean, changeCount: Int): Unit = {
    var xBeforeUpdated = xBefore
    var xCountUpdated = xCount
    var tempMaxUpdated = tempMax
    var changeCountUpdated = changeCount

    val sTarget = s(index).toString

    if (sTarget == "X") {
      xBeforeUpdated = true
      xCountUpdated = xCountUpdated + 1
      if (xCountUpdated > tempMax) {
        tempMaxUpdated = xCountUpdated
      }
      if (index < length - 1) {
        sCount(index + 1, tempMaxUpdated, xCountUpdated, true, changeCountUpdated)
      } else {
        if (tempMaxUpdated > result) {
          result = tempMaxUpdated
        }
      }
    } else {
      if (changeCount < k) {
        if (index == length - 1) {
          xBeforeUpdated = true
          xCountUpdated = xCountUpdated + 1
          changeCountUpdated = changeCountUpdated + 1
          if (xCountUpdated > tempMax) {
            tempMaxUpdated = xCountUpdated
          }
          if (index < length - 1) {
            sCount(index + 1, tempMaxUpdated, xCountUpdated, true, changeCountUpdated)
            sCount(index + 1, tempMax, 0, false, changeCount)
          } else {
            if (tempMaxUpdated > result) {
              result = tempMaxUpdated
            }
          }
        } else {
          val next = s(index + 1).toString
          if (!xBefore && next == ".") {
            sCount(index + 1, tempMax, 0, false, changeCount)
          } else {
            xBeforeUpdated = true
            xCountUpdated = xCountUpdated + 1
            changeCountUpdated = changeCountUpdated + 1
            if (xCountUpdated > tempMax) {
              tempMaxUpdated = xCountUpdated
            }
            sCount(index + 1, tempMaxUpdated, xCountUpdated, true, changeCountUpdated)
            sCount(index + 1, tempMax, 0, false, changeCount)
          }
        }
      } else {
        if (index < length - 1) {
          sCount(index + 1, tempMaxUpdated, 0, false, changeCountUpdated)
        } else {
          if (tempMaxUpdated > result) {
            result = tempMaxUpdated
          }
        }
      }
    }
  }

  if (k >= length) {
    println(length)
  } else {
    sCount(0, 0, 0, false, 0)
    println(result)
  }
}
