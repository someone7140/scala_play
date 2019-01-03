package beginnersSelection

// https://atcoder.jp/contests/abs/tasks/abc081_b

object Abc081bShiftonly extends App {
  var n = scala.io.StdIn.readInt()
  var s = scala.io.StdIn.readLine()
  val inputArray =  s.split(" ")
  var count = 0

  def judgeEvenAll(inputArray: Seq[Int]): Boolean = {
    !inputArray.exists(_ % 2 == 1)
  }
  
  def divideAll(inputArray: Seq[Int], count: Int): Int = {
    if (judgeEvenAll(inputArray)) {
      divideAll(inputArray.map(_ / 2), count + 1)
    } else {
      count
    }
  }
  println(divideAll(inputArray.map(_.toInt), count))
}