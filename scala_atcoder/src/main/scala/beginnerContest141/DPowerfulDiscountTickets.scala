package beginnerContest141

// https://atcoder.jp/contests/abc141/tasks/abc141_d

object DPowerfulDiscountTickets extends App {

  val inputnm = scala.io.StdIn.readLine()
  val nmArray = inputnm.split(" ").map(_.toInt).toVector
  val inputa = scala.io.StdIn.readLine()

  val n = nmArray(0)
  val m = nmArray(1)
  var aArray = inputa.split(" ").map(_.toLong).toVector

  (1 to m).foreach { _ =>
    if (aArray.size > 0) {
      val max = aArray.max
      aArray = aArray.updated(aArray.indexWhere(_ == max), max / 2L).filter(_ > 0)
    }
  }

  println(aArray.sum)

}
