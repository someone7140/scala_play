package beginnerContest127

// https://atcoder.jp/contests/abc127/tasks/abc127_c

import scala.util.control.Breaks

object CPrison extends App {
  val read = scala.io.StdIn.readLine()
  val array =  read.split(" ").map(_.toInt).toVector
  val n = array(0)
  val m = array(1)
  var lrArr = Vector.empty[(Int, Int)]
  var result = (0, 0)
  for(i<-1 to m) {
    val readLR = scala.io.StdIn.readLine()
    val arrayLR =  readLR.split(" ").map(_.toInt).toVector
    lrArr :+= (arrayLR(0), arrayLR(1))
  }
  val b = new Breaks

  b.breakable{
    lrArr.zipWithIndex.foreach { case (lr, i) =>
      if(i == 0) {
        result = lr
      } else {
        var min = 0
        var max = 0
        if (result._1 >= lr._1) {
          min = result._1
        } else {
          min = lr._1
        }
        if (result._2 >= lr._2) {
          max = lr._2
        } else {
          max = result._2
        }
        if(min > max) {
          result = (0, 0)
          b.break()
        } else {
          result = (min, max)
        }
      }
    }
  }
  if (result._1 == 0 && result._2 == 0) {
    print(0)
  } else {
    print(result._2 - result._1 + 1)
  }

}
