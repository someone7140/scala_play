package beginnerContest135

// https://atcoder.jp/contests/abc135/tasks/abc135_c

object CCitySavers extends App {
  val n = scala.io.StdIn.readInt()
  val readA = scala.io.StdIn.readLine()
  val aArray =  readA.split(" ").map(_.toInt).toVector
  val readB = scala.io.StdIn.readLine()
  val bArray =  readB.split(" ").map(_.toInt).toVector

  var bArrayTemp =  bArray
  var result = 0L
  var tempB = 0
  var bIndex = 0
  aArray.zipWithIndex.foreach { case (a, index) =>
    if (index == 0) {
      tempB = bArray(bIndex)
    }
    if(tempB <= a) {
      result = result + tempB.toLong
      if (bIndex != n - 1) {
        if(bIndex < index) {
          bIndex = bIndex + 1
          tempB = bArray(bIndex)
          if(tempB <= a) {
            result = result + tempB.toLong
            if(bIndex != n - 1) {
              bIndex = bIndex + 1
              tempB = bArray(bIndex)
            } else {
              tempB = 0
            }
          } else {
            result = result + tempB.toLong
            tempB = tempB - a
          }
        } else {
          bIndex = bIndex + 1
          tempB = bArray(bIndex)
        }
      } else {
        tempB = 0
      }
    } else {
      result = result + tempB.toLong
      tempB = tempB - a
    }
  }
  println(result)
}
