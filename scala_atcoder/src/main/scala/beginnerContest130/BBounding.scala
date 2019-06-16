package beginnerContest130

//https://atcoder.jp/contests/abc130/tasks/abc130_b

import scala.util.control.Breaks

object BBounding extends App {
  val read = scala.io.StdIn.readLine()
  val NxArray =  read.split(" ").map(_.toInt).toVector
  var sum = 0
  var count = 1
  val read2 = scala.io.StdIn.readLine()
  val LArray =  read2.split(" ").map(_.toInt).toVector

  val b = new Breaks
  b.breakable{
    LArray.foreach { l =>
      if (sum + l > NxArray(1)) {
        b.break()
      } else {
        count = count + 1
        sum = sum + l
      }

    }
  }
  println(count)

}
