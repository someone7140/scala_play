package beginnerContest130

//https://atcoder.jp/contests/abc130/tasks/abc130_d

import scala.util.control.Breaks

object DEnoughArray extends App {
  val read = scala.io.StdIn.readLine()
  val NkArray =  read.split(" ").map(_.toInt).toVector
  val read2 = scala.io.StdIn.readLine()
  val AArray =  read2.split(" ").map(_.toLong).toVector.sorted.reverse
  var count = 0
  val length = AArray.length

  val b = new Breaks
  b.breakable{
    AArray.zipWithIndex.foreach { case(_, i) =>
      val slice = AArray.slice(i, length)
      var sum = 0L
      var i1 = -1
      val b1 = new Breaks
      b1.breakable {
        slice.zipWithIndex.foreach { case (s, i2) =>
          sum = sum + s
          if (sum >= NkArray(1)) {
            i1 = i2
            b1.break
          }
        }
      }
      if(i1 > -1) {
        count = count + length - i - i1
      } else {
        b.break
      }
    }
  }
  println(count)

}
