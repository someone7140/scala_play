package beginnerContest233

import scala.math.round

object A10yenStamp extends App {
  val xyVector = scala.io.StdIn.readLine().split(" ").map(_.toInt).toVector
  val x = xyVector(0)
  val y = xyVector(1)

  val sabun = y - x

  if (sabun <= 0) {
    println(0)
  } else {
    val sabunAmari = sabun % 10
    val sabunSyou = sabun / 10
    if (sabunAmari > 0) {
      println(sabunSyou + 1)
    } else {
      println(sabunSyou)
    }
  }
}
