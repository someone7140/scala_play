package beginnerContest140

// https://atcoder.jp/contests/abc140/tasks/abc140_b

object BBuffet extends App {

  val n = scala.io.StdIn.readInt()
  val readA =  scala.io.StdIn.readLine()
  val aArray = readA.split(" ").map(_.toInt).toVector
  val readB =  scala.io.StdIn.readLine()
  val bArray = readB.split(" ").map(_.toInt).toVector
  val readC =  scala.io.StdIn.readLine()
  val cArray = readC.split(" ").map(_.toInt).toVector

  var result = 0
  var before = -1
  aArray.foreach { a =>
    result = result + bArray(a - 1)
    if (before > 0 && a == (before + 1)) {
      result = result + cArray(before - 1)
    }
    if (a <= cArray.size) {
      before = a
    } else {
      before = -1
    }

  }
  println(result)
}
