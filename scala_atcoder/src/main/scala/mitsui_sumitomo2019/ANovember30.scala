package mitsui_sumitomo2019

// https://atcoder.jp/contests/sumitrust2019/tasks/sumitb2019_a

object ANovember30 extends App {
  val md1 = scala.io.StdIn.readLine()
  val md1Array = md1.split(" ").map(_.toInt).toVector
  val md2 = scala.io.StdIn.readLine()
  val md2Array = md2.split(" ").map(_.toInt).toVector

  if(md1Array(0) == md2Array(0)) {
    println(0)
  } else {
    println(1)
  }
}

