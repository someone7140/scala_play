package aising2020

// https://atcoder.jp/contests/aising2020/tasks/aising2020_a

object ANumberofMultiples extends App {
  val lrdInput =  scala.io.StdIn.readLine()
  val lrdArray = lrdInput.split(" ").map(_.toInt).toSeq

  val l = lrdArray(0)
  val r = lrdArray(1)
  val d = lrdArray(2)

  var result = 0
  (l to r).foreach { i =>
    if (i % d == 0) {
      result = result + 1
    }
  }

  println(result)
}
