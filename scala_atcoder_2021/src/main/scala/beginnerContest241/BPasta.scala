package beginnerContest241

object BPasta extends App {
  val nmVector = scala.io.StdIn.readLine().split(" ").map(_.toInt).toVector
  val n = nmVector(0)
  val m = nmVector(1)

  val aArray = scala.io.StdIn.readLine().split(" ").map(_.toInt)
  val bArray = scala.io.StdIn.readLine().split(" ").map(_.toInt)

  var aMap = scala.collection.mutable.Map[Int, Int]()

  aArray.foreach(a => {
    val aOpt = aMap.get(a)
    if (aOpt.isEmpty) {
      aMap.put(a, 1)
    } else {
      aMap.put(a, aOpt.get + 1)
    }
  })

  var result = "Yes"
  bArray.foreach(b => {
    val aValueOpt = aMap.get(b)
    if (aValueOpt.isEmpty) {
      result = "No"
    } else {
      val aValue = aValueOpt.get
      if (aValue > 0) {
        aMap.put(b, aValue - 1)
      } else {
        result = "No"
      }
    }
  })

  println(result)
}
