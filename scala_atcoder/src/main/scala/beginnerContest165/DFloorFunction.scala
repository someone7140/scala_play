package beginnerContest165

// https://atcoder.jp/contests/abc165/tasks/abc165_d

object DFloorFunction extends App {
  val abn =  scala.io.StdIn.readLine()
  val abnArray = abn.split(" ").map(_.toLong).toSeq
  val a = abnArray(0)
  val b = abnArray(1)
  val n = abnArray(2)

  var tempMax = 0L

  (0L to n).foreach { x =>
    val temp1 = a * x / b
    val temp2 = x / b
    val tempResult = temp1 - a * temp2
    if(tempMax < tempResult) {
      tempMax = tempResult
    }

  }
  println(tempMax)
}
