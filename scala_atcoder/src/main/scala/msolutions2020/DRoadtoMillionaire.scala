package msolutions2020

// https://atcoder.jp/contests/m-solutions2020/tasks/m_solutions2020_d

object DRoadtoMillionaire extends App {
  val n = scala.io.StdIn.readInt()
  val aInput = scala.io.StdIn.readLine()
  val aArray =  aInput.split(" ").map(_.toLong).toVector

  var beforeTanka = -1L
  var kabusuu = 0L
  var amount = 1000L

  aArray.zipWithIndex.foreach { a =>
    val tanka = a._1
    val index = a._2
    if (beforeTanka == -1L) {
      beforeTanka = tanka
    } else {
      if (beforeTanka < tanka) {
        // 株数がなかったら前の単価で買う
        if (kabusuu == 0L) {
          kabusuu = amount / beforeTanka
          amount = amount - (kabusuu * beforeTanka)
        }
      } else if (beforeTanka > tanka) {
        // 株数があったら前の単価で売る
        if (kabusuu != 0L) {
          amount = amount + (kabusuu * beforeTanka)
          kabusuu = 0L
        }
      }
      // これが最後だったら売る
      if (index == n - 1) {
        amount = amount + (kabusuu * tanka)
        kabusuu = 0L
      }
      beforeTanka = tanka
    }
  }

  println(amount)

}
