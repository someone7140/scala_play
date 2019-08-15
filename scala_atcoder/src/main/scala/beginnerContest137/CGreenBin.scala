package beginnerContest137

// https://atcoder.jp/contests/abc137/tasks/abc137_c

object CGreenBin extends App {
  val n = scala.io.StdIn.readInt()
  var sArray = Vector.empty[String]
  (1 to n).foreach { _ =>
    val readS = scala.io.StdIn.readLine()
    sArray :+= readS.sorted
  }
  val result = sArray.groupBy(s => s).map(s => s._2.size.toLong).filter(_ >= 2L).map(s => (s * (s - 1L)) / 2L ).sum
  println(result)
}
