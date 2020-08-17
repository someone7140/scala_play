package beginnerContest175

// https://atcoder.jp/contests/abc175/tasks/abc175_b

import scala.util.control.Breaks

object BMakingTriangle extends App {
  val n = scala.io.StdIn.readInt()
  val lInput = scala.io.StdIn.readLine()
  val lArray = lInput.split(" ").map(_.toLong).toVector

  val lArraySorted = lArray.toSet.toVector.sorted
  val sortedLength = lArraySorted.length
  val groupedMap = lArray.groupBy(l => l)
  var result = 0

  def setTriangle(head: Long, tail: Vector[Long]): Unit = {
    tail.zipWithIndex.foreach { t =>
      if (head < t._1) {
        val second = (head, t._1)
        setThirdPosition(second, tail.drop(t._2 + 1))
      }
    }
  }

  def setThirdPosition(nihen: (Long, Long), tail: Vector[Long]): Unit = {
    val b = new Breaks
    b.breakable {
      tail.foreach { t =>
        if ((nihen._1 + nihen._2) > t && t > Math.abs((nihen._1 - nihen._2))) {
          val firstCount = groupedMap.get(nihen._1).get.size
          val secondCount = groupedMap.get(nihen._2).get.size
          val thirdCount = groupedMap.get(t).get.size
          result = result + (firstCount * secondCount * thirdCount)
        } else {
          b.break()
        }
      }
    }
  }

  if (sortedLength > 2) {
    var count = sortedLength
    var tempSortedArray = lArraySorted
    while (count > 2) {
      val head = tempSortedArray.head
      tempSortedArray = tempSortedArray.tail
      setTriangle(head, tempSortedArray)
      count = count - 1
    }
    println(result)
  } else {
    println(0)
  }

}
