package mitsui_sumitomo2019

// https://atcoder.jp/contests/sumitrust2019/tasks/sumitb2019_c

object C100to105 extends App {
  val n =  scala.io.StdIn.readInt()
  if (n < 100) {
    println(0)
  } else {
    val simoNiketa = n % 100
    val divideBy5 = simoNiketa / 5
    var saiteiKosuu = 0
    if (simoNiketa % 5 == 0) {
      saiteiKosuu = divideBy5
    } else {
      saiteiKosuu = divideBy5 + 1
    }
    if (saiteiKosuu * 100 > n) {
      println(0)
    } else {
      println(1)
    }
  }
}
