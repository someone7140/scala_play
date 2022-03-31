package beginnerContest245

import scala.util.control.Breaks

object BMex extends App {
  val n =  scala.io.StdIn.readInt()
  val aVec = scala.io.StdIn.readLine().split(" ").map(_.toInt).toSet.toVector.sorted

  var result = -1
  val b = new Breaks
  var breakFlag = false
  b.breakable {
    aVec.foreach(a => {
      if ((a - 1) == result) {
        result = a
      } else {
        result = result + 1
        breakFlag = true
        b.break()
      }
    })
  }
  if (!breakFlag) {
    result = result + 1
  }
  println(result)
}
