package beginnerContest148

// https://atcoder.jp/contests/abc148/tasks/abc148_b

object DBrickBreak extends App {
  val n = scala.io.StdIn.readInt()
  val aInput = scala.io.StdIn.readLine()
  val aArray = aInput.split(" ").map(_.toInt).toVector
  var result = 0
  var index = 1
  aArray.foreach { a =>
    if(index == a) {
      index += 1
    } else {
      result += 1
    }
  }
  if (result == n) {
    println(-1)
  } else {
    println(result)
  }
}
