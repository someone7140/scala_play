package beginnerContest118

// https://atcoder.jp/contests/abc118/tasks

object DMatchMatching extends App {
  var nm = scala.io.StdIn.readLine()
  var nmArray = nm.split(" ").map(_.toInt)
  val n = nmArray(0)

  val matchCountArray = Vector(2,5,5,4,5,6,3,7,6)

  var a = scala.io.StdIn.readLine()
  val aArray =  a.split(" ").toVector.map(_.toInt).map(a=> (a, matchCountArray(a-1))).sortWith((a1, a2) =>
    if (a1._2 < a2._2 ) {
      true
    } else {
      a1._1 > a2._1
    }
  )

}
