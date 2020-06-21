package beginnerContest170

// https://atcoder.jp/contests/abc170/tasks/abc170_c

object CForbiddenList extends App {
  val xn =  scala.io.StdIn.readLine()
  val xnArray = xn.split(" ").map(_.toInt).toSeq
  val x = xnArray(0)
  val n = xnArray(1)

  val pInput =  scala.io.StdIn.readLine()

  if (n == 0) {
    println(x)
  } else {
    val pArray = pInput.split(" ").map(_.toInt).toVector.sorted
    if (pArray.find(_ == x).isEmpty) {
      println(x)
    } else {
      val min = pArray.head - 1
      val minSabun = Math.abs(x - min)
      val max = pArray.last + 1
      val maxSabun = Math.abs(x - max)

      var temp = -999
      var sabun = -999
      var result = -999
      if (minSabun > maxSabun) {
        sabun = maxSabun
        result = max
      } else {
        sabun = minSabun
        result = min
      }
      pArray.zipWithIndex.foreach { p =>
        if (temp == -999) {
          temp = p._1
        } else if (temp + 1 == p._1) {
          temp = p._1
        } else {
          // 現状より一つ前の値
          (temp + 1 to p._1 - 1).foreach { i =>
            val tempSabun = Math.abs(x - i)
            if (tempSabun < sabun) {
              sabun = tempSabun
              result = i
            } else if (tempSabun == sabun && i < result) {
              sabun = tempSabun
              result = i
            }
          }
          temp = p._1
        }
      }
      println(result)
    }
  }
}
