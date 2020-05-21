package beginnerContest168

// https://atcoder.jp/contests/abc168/tasks/abc168_d

object DDoubleDots extends App {
  val nm = scala.io.StdIn.readLine()
  val nmArray = nm.split(" ").map(_.toInt).toSeq
  val n = nmArray(0)
  val m = nmArray(1)

  var roomMap = scala.collection.mutable.Map.empty[Int, Seq[Int]]
  var resultMap = scala.collection.mutable.Map.empty[Int, (Int, Int)]
  (1 to n).foreach { i =>
    roomMap.put(i, Seq.empty[Int])
  }
  (2 to n).foreach { i =>
    resultMap.put(i, (0, 0))
  }
  (1 to m).foreach { _ =>
    val ab = scala.io.StdIn.readLine()
    val abArray = ab.split(" ").map(_.toInt).toSeq
    val a = abArray(0)
    val b = abArray(1)
    roomMap.put(a, roomMap.get(a).getOrElse(Seq.empty[Int]) ++ Seq(b))
    roomMap.put(b, roomMap.get(b).getOrElse(Seq.empty[Int]) ++ Seq(a))
  }

  def setResult(count: Int, index: Int, beforeIndex: Int): Unit = {
    if (index != 1) {
      val result = resultMap.get(index).getOrElse((0, 0))
      if (result._1 == 0) {
        resultMap.put(index, (count, beforeIndex))
      } else {
        if (result._1 > count) {
          resultMap.put(index, (count, beforeIndex))
        }
      }
    }
    val root = roomMap.get(index).getOrElse(Seq.empty[Int])
    if (root.length > 0) {
      root.foreach { r =>
        if (r != 1) {
          val tempR = resultMap.get(r).getOrElse((0, 0))
          if (tempR._1 == 0 || tempR._1 > count + 1) {
            setResult(count + 1, r, index)
          }
        }
      }
    }
  }

  setResult(0, 1, 1)

  if (resultMap.find(r => r._2 == 0).isDefined) {
    println("No")
  } else {
    println("Yes")
    resultMap.toVector.sortBy(_._1).foreach { r =>
      println(r._2._2)
    }
  }
}
