package beginnerContest139

// https://atcoder.jp/contests/abc139/tasks/abc139_c

object CLower extends App {
  val n = scala.io.StdIn.readInt()
  val readH =  scala.io.StdIn.readLine()
  val h = readH.split(" ").map(_.toInt).toVector
  var result = 0
  var tempResult = -1
  var beforeValue = -1

  h.foreach { i =>
    if (i <= beforeValue) {
      beforeValue = i
      tempResult += 1
      if (tempResult > result) {
        result = tempResult
      }
    } else {
      tempResult = 0
      beforeValue = i
    }
  }
  println(result)
}
