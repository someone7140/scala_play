package beginnerContest137

// https://atcoder.jp/contests/abc137/tasks/abc137_a

object Ax extends App {
  val read = scala.io.StdIn.readLine()
  val array =  read.split(" ").map(_.toInt).toVector
  println(Vector(array(0) + array(1), array(0) - array(1), array(0) * array(1)).max)
}
