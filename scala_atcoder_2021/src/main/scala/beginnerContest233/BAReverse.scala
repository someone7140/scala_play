package beginnerContest233

object BAReverse extends App {
  val lrVector = scala.io.StdIn.readLine().split(" ").map(_.toInt).toVector
  val l = lrVector(0)
  val r = lrVector(1)
  val s = scala.io.StdIn.readLine()
  val sLength = s.length

  val before = if (l > 0) s.substring(0, l - 1) else ""
  val after = if (sLength == r) "" else s.substring(r, sLength)
  val center = s.substring(l - 1, r).reverse

  println(before + center + after)
}
