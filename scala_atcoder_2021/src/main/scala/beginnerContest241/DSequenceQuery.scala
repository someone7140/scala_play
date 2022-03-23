package beginnerContest241

import scala.collection.mutable
import scala.util.control.Breaks

object DSequenceQuery extends App {
  val q = scala.io.StdIn.readInt()

  var resultList = Vector.empty[Long]
  val aTreeSet = new java.util.TreeSet[Long]()
  val aCountMap = new mutable.HashMap[Long, Int]()

  (1 to q).foreach(_ => {
    val queryArray = scala.io.StdIn.readLine().split(" ")
    if (queryArray(0) == "1") {
      val x = queryArray(1).toLong
      aTreeSet.add(x)
      // 出現回数
      aCountMap.get(x).fold(aCountMap.addOne(x, 1))(count => {
        aCountMap.addOne(x, count + 1)
      })
    } else if (queryArray(0) == "2") {
      val x = queryArray(1).toLong
      val k = queryArray(2).toInt
      // x以下のコレクション
      val xLowerSet = aTreeSet.headSet(x, true)
      var result = -1L
      var count = 0
      val b = new Breaks
      val setSize = xLowerSet.size
      var temp = x
      b.breakable {
        // 大きい方からカウントしていく
        (1 to setSize).foreach(_ => {
          temp = xLowerSet.lower(temp)
          count += aCountMap.get(temp).getOrElse(0)
          if (count >= k) {
            result = temp
            b.break()
          }
          temp = temp - 1
        })
      }
      resultList :+= result
    } else {
      val x = queryArray(1).toLong
      val k = queryArray(2).toInt
      // x以上のコレクション
      val xUpperSet = aTreeSet.tailSet(x, true)
      var result = -1L
      var count = 0
      val b = new Breaks
      val setSize = xUpperSet.size
      var temp = x
      b.breakable {
        // 小さい方からカウントしていく
        (1 to setSize).foreach(_ => {
          temp = xUpperSet.higher(temp)
          count += aCountMap.get(temp).getOrElse(0)
          if (count >= k) {
            result = temp
            b.break()
          }
          temp = temp + 1
        })
      }
      resultList :+= result
    }
  })

  println(resultList.mkString(System.lineSeparator))
}
