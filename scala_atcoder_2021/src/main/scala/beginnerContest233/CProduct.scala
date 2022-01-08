package beginnerContest233

object CProduct extends App {
  val nxVector = scala.io.StdIn.readLine().split(" ").map(_.toLong).toVector
  val n = nxVector(0)
  val x = nxVector(1)
  var result = 0L

  val aMapArray = new Array[scala.collection.mutable.Map[Long, Long]](n.toInt)

  (0 to (n - 1).toInt).foreach(i => {
    val laVector = scala.io.StdIn.readLine().split(" ").map(_.toLong).toVector
    var aMap = scala.collection.mutable.Map[Long, Long]()

    laVector.tail.foreach(a => {
      aMap.get(a).fold(aMap += a -> 1L)(getA => {
        aMap += a -> (getA + 1L)
      })
    })
    aMapArray(i) = aMap
  })

  def calc(total: Long, index: Int, count: Long): Unit = {
    if (index == n) {
      if (total == x) {
        result = result + count
      }
    } else {
      if (total <= x) {
        val nextMap = aMapArray(index)
        nextMap.foreach(aCalc => {
          calc(total * aCalc._1, index + 1, count * aCalc._2)
        })
      }
    }
  }

  aMapArray(0).foreach(aFirst => {
    calc(aFirst._1, 1, aFirst._2)
  })

  println(result)
}
