package beginnerContest149

// https://atcoder.jp/contests/abc149/tasks/abc149_d

object DPredictionandRestriction extends App {
  val nk = scala.io.StdIn.readLine()
  val nkArray = nk.split(" ").map(_.toInt).toVector
  val n = nkArray(0)
  val k = nkArray(1)
  val rsp = scala.io.StdIn.readLine()
  val rspArray = rsp.split(" ").map(_.toInt).toVector
  val r = rspArray(0)
  val s = rspArray(1)
  val p = rspArray(2)
  val t = scala.io.StdIn.readLine()
  var jankenResult = ""
  var jankenResult2 = ""
  var scoreSum = 0
  def getScore(janken: String): Int = {
    if (janken == "r") {
      r
    } else if (janken == "s") {
      s
    } else if (janken == "p") {
      p
    } else {
      0
    }
  }

  // まずは全て勝つ手を設定する
  t.foreach { c =>
    val janken = c.toString
    if (janken == "r") {
      jankenResult = jankenResult + "p"
    } else if (janken == "s") {
      jankenResult = jankenResult + "r"
    } else {
      jankenResult = jankenResult + "s"
    }
  }
  // 2個前の判定
  jankenResult.zipWithIndex.foreach { j =>
    val janken = j._1.toString
    val index = j._2
    if (index < k) {
      jankenResult2 = jankenResult2 + janken
    } else if (jankenResult2(index - k).toString != janken) {
      jankenResult2 = jankenResult2 + janken
    } else {
      jankenResult2 = jankenResult2 + "x"
    }
  }
  // 点数計算
  jankenResult2.foreach { j =>
    val janken = j.toString
    scoreSum = scoreSum + getScore(janken)
  }
  println(scoreSum)
}
