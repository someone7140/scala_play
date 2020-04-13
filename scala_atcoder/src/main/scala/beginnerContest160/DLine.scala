package beginnerContest160

// https://atcoder.jp/contests/abc160/tasks/abc160_d

object DLine extends App {
  val nxyInput = scala.io.StdIn.readLine()
  val nxyArray = nxyInput.split(" ").map(_.toInt).toSeq
  val n = nxyArray(0)
  val x = nxyArray(1)
  val y = nxyArray(2)
  var mapResult = scala.collection.mutable.Map.empty[Int, Int]
  (1 to n - 1).foreach { i =>
    if (i == x + 1) {
      (y to n).foreach { j =>
        val distance = j - y + 1
        mapResult.put(distance, mapResult.get(distance).getOrElse(0) + 1)
        println(s"${i}, ${j}, ${distance}")
      }
    } else if(i > x + 1) {
      (i + 1 to n).foreach { j =>
        val distance = j - i
        mapResult.put(distance, mapResult.get(distance).getOrElse(0) + 1)
        println(s"${i}, ${j}, ${distance}")
      }
    } else {
      (i + 1 to n).foreach { j =>
        if (j <= x) {
          val distance = j - i
          mapResult.put(distance, mapResult.get(distance).getOrElse(0) + 1)
          println(s"${i}, ${j}, ${distance}")
        } else if (j > x && j < y) {
          val distance = j - i
          mapResult.put(distance, mapResult.get(distance).getOrElse(0) + 1)
          println(s"${i}, ${j}, ${distance}")
        } else {
          val distance = j - i - (y - x - 1)
          mapResult.put(distance, mapResult.get(distance).getOrElse(0) + 1)
          println(s"${i}, ${j}, ${distance}")
        }

      }
    }

  }
  (1 to n - 1).foreach { i =>
    println(mapResult.get(i).getOrElse(0))
  }
}
