package beginnerContest163

// https://atcoder.jp/contests/abc163/tasks/abc163_c

object Cmanagement extends App {
  val n =  scala.io.StdIn.readInt()
  var aMap = scala.collection.mutable.Map.empty[Int, Int]
  val aInput =  scala.io.StdIn.readLine()
  aMap.put(1, 0)
  aInput.split(" ").zipWithIndex.foreach { a =>
    aMap.put(a._2 + 2, 0)
    val jousiCount = aMap.get(a._1.toInt).getOrElse(0)
    aMap.put(a._1.toInt, jousiCount + 1)
  }
  aMap.toVector.sortBy(a => a._1).foreach { a =>
    println(a._2)
  }
}