package beginnerContest129

// https://atcoder.jp/contests/abc129/tasks/abc129_b

import scala.util.control.Breaks

object BBalance extends App {
  val n = scala.io.StdIn.readInt()
  val read = scala.io.StdIn.readLine()
  val array =  read.split(" ").map(_.toInt).toVector
  var diff = 0

  val b = new Breaks
  b.breakable{
    for(i<-0 to (n - 1)) {
      val left = array.slice(0, i + 1).sum
      val right = array.slice(i + 1, n).sum
      val tempDiff = Math.abs(left - right)
      if (i == 0 || diff > tempDiff) {
        diff = tempDiff
      } else{
        b.break()
      }
    }
  }
  println(diff)
}
