package beginnerContest174

// https://atcoder.jp/contests/abc174/tasks/abc174_b

object BDistance extends App {
  val nd =  scala.io.StdIn.readLine()
  val ndArray = nd.split(" ").map(_.toLong).toSeq
  val n = ndArray(0)
  val d = ndArray(1)

  val dMulti = d * d
  var count = 0

  (1L to n).foreach { _ =>
    val xy =  scala.io.StdIn.readLine()
    val xyArray = xy.split(" ").map(_.toLong).toSeq
    val x = xyArray(0)
    val y = xyArray(1)

    val xMulti = x * x
    val yMulti = y * y

    if ((xMulti + yMulti) <= dMulti) {
      count = count + 1
    }
  }

  println(count)
}
