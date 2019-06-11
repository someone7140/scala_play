package beginnerContest129

// https://atcoder.jp/contests/abc129/tasks/abc129_c

import scala.util.control.Breaks

object CTypicalStairs extends App {
  val read = scala.io.StdIn.readLine()
  val array =  read.split(" ").map(_.toInt)
  val n = array(0)
  val m = array(1)
  var a =Vector.empty[Int]
  for(i<-1 to m) {
    a :+= scala.io.StdIn.readInt()
  }
  var zeroFLg = false
  a.zipWithIndex.foreach { case (v, i) =>
    if(i != m - 1) {
      if(v + 1 == a(i + 1)) {
        zeroFLg = true
      }
    } else {
      if(v == n) {
        zeroFLg = true
      }
    }
  }
  if(zeroFLg) {
    println(0)
  } else {
    var count = 0
    for(i<-0 to n - 2) {
      if (a.find(_ == i).isEmpty){
        val optPlusOne = a.find(_ == i + 1)
        val optPlusTwo = a.find(_ == i + 2)
        if(optPlusOne.isEmpty && optPlusTwo.isEmpty) {
          count = count + 1
        }
      }
    }
    println((Math.pow(2, count) % 1000000007L).toLong)
  }
}
