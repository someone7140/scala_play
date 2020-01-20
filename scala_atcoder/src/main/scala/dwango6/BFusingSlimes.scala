package dwango6

// https://atcoder.jp/contests/dwacon6th-prelims/tasks/dwacon6th_prelims_b

object BFusingSlimes extends App {
  val n = scala.io.StdIn.readInt()
  val x = scala.io.StdIn.readLine()
  val array = x.split(" ").map(_.toLong).toVector
  var sum = 0L
  def sumExperience(xArray: Vector[Long]): Unit = {
    val length = xArray.length
    if (length != 1) {
      xArray.zipWithIndex.foreach { x =>
        if (x._2 != (length - 1)) {
          sum = (sum + xArray(x._2 + 1) - x._1)
          sumExperience(xArray.filter(x2 => x2 != x._1))
        }
      }
    }
  }
  sumExperience(array)
  println(sum % 1000000007)
}
