package beginnerContest155

// https://atcoder.jp/contests/abc155/tasks/abc155_c

object CPoll extends App {
  val n = scala.io.StdIn.readInt()
  var sMap = scala.collection.mutable.Map.empty[String, Int]
  var maxCount = 0
  (1 to n).foreach { _ =>
    val s = scala.io.StdIn.readLine()
    var count = sMap.get(s).getOrElse(0)
    count = count + 1
    if (maxCount < count) {
      maxCount = count
    }
    sMap.put(s, count)
  }
  sMap.toSeq.sortBy(s => s._1).foreach { s =>
    if (s._2 == maxCount) {
      println(s._1)
    }
  }
}
