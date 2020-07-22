package aising2020

// https://atcoder.jp/contests/aising2020/tasks/aising2020_b

object BAnOddProblem extends App {
  val n = scala.io.StdIn.readInt()
  val aInput =  scala.io.StdIn.readLine()
  val aArray = aInput.split(" ").map(_.toInt).toVector

  var result = 0
  (1 to aArray.length).foreach { i =>
    if (i % 2 == 1 && aArray(i - 1) % 2 == 1) {
      result = result + 1
    }
  }

  println(result)
}
