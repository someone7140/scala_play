package beginnerContest138

// https://atcoder.jp/contests/abc138/tasks/abc138_d

object DKi extends App {
  val nq = scala.io.StdIn.readLine()
  val nqArray = nq.split(" ").map(_.toInt).toVector
  val n = nqArray(0)
  val q = nqArray(1)
  var kiMap = scala.collection.mutable.Map.empty[Int, Seq[Int]]
  (1 to n - 1).foreach { _ =>
    val ab = scala.io.StdIn.readLine()
    val abArray = ab.split(" ").map(_.toInt).toVector
    kiMap.get(abArray(0)).fold {
      kiMap.put(abArray(0) ,Seq(abArray(1)))
    } { bSeq =>
      val newSeq = bSeq :+ abArray(1)
      kiMap.put(abArray(0) ,newSeq)
    }
  }
}
