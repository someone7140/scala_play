package beginnerContest119

// https://atcoder.jp/contests/abc119/tasks/abc119_c

import scala.math._

object CSyntheticKadomatsu extends App {
  var nabc = scala.io.StdIn.readLine()
  val nabcArray = nabc.split(" ").map(_.toInt)
  val n = nabcArray(0)
  val abcArrayInput = nabcArray.tail
  var abcArray = Seq((abcArrayInput(0),0), (abcArrayInput(1),0), (abcArrayInput(2),0))
  var lVector = Vector.empty[Int]
  var mp = 0
  for(i<-1 to n) {
    val l = scala.io.StdIn.readInt
    if(abcArray.length != 0) {
      if(abcArray.find(_ == l).isDefined) {
        abcArray = abcArray.filterNot(_ == l)
      } else {
        abcArray = abcArray.map{ n =>
          if(n._2 == 0) {
            (n._1, l)
          } else if (abs(n._1 - n._2) > (n._1 - l)) {
            (n._1, l)
          } else {
            n
          }
        }
        lVector :+= l
      }
    }
  }
  abcArray = abcArray.filter { n =>
    if (n._2 < 11) {
      mp += (n._1 - n._2).abs
      var tempLVector = Vector.empty[Int]
      var findFlg = false
      for(i<-0 to (lVector.length - 1)) {

      }
      false
    }
    else {
      true
    }
  }

}
