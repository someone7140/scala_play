package beginnerContest236

object DDance extends App {
  val n = scala.io.StdIn.readInt() * 2
  val aArray = new Array[Array[Long]](n - 1)

  (0 to n - 2).foreach(i => {
    val a = scala.io.StdIn.readLine().split(" ").map(_.toLong)
    aArray(i) = a
  })

  if (n == 2) {
    println(aArray(0)(0))
  } else {
    var result = -999999L

    def getTanoshisa(pare: (Int, Int)): Long = {
      if (pare._1 < pare._2) {
        aArray(pare._1)(pare._2 - pare._1 - 1)
      } else {
        aArray(pare._2)(pare._1 - pare._2 - 1)
      }
    }

    def calc(tempResult: Long, cSeq: IndexedSeq[Int]): Unit = {
      if (cSeq.length == 2) {
        val temp = tempResult ^ getTanoshisa(cSeq(0), cSeq(1))
        if (temp > result) {
          result = temp
        }
      } else {
        val combinations2 = cSeq.combinations(2).toVector
        combinations2.foreach(c => {
          val temp = tempResult ^ getTanoshisa(c(0), c(1))
          calc(temp, cSeq.filter(c2 => !c.exists(c3 => c3 == c2)))
        })
      }
    }


    val combinations2 = (0 to n - 1).combinations(2).toVector
    combinations2.foreach(c => {
      val temp = getTanoshisa(c(0), c(1))
      calc(temp, (0 to n - 1).filter(c2 => !c.exists(c3 => c3 == c2)))
    })

    println(result)

  }

}
