package beginnerContest243

object CCollision2 extends App {
  val n = scala.io.StdIn.readInt()
  val yxMap = scala.collection.mutable.Map.empty[Int, Vector[(Int, String)]]
  val xyStringArray = new Array[String](n)
  (0 to n - 1).foreach(i => {
    xyStringArray(i) = scala.io.StdIn.readLine()
  })
  val sCharArray = scala.io.StdIn.readLine().toCharArray
  val ySet = scala.collection.mutable.Set.empty[Int]
  xyStringArray.zipWithIndex.foreach(xyString => {
    val xy = xyString._1.split(" ").map(_.toInt)
    val y = xy(1)
    ySet.add(y)

    val xDirection = (xy(0), sCharArray(xyString._2).toString)
    val xDirectionsOpt = yxMap.get(y)
    if (xDirectionsOpt.isEmpty) {
      yxMap.put(y, Vector(xDirection))
    } else {
      yxMap.put(y, xDirectionsOpt.get :+ xDirection)
    }
  })

  var result = "No"

  ySet.foreach(y => {
    val xDirections = yxMap.get(y).get.sortBy(_._1)
    var rFlag = false
    xDirections.foreach(xd => {
      val d = xd._2
      if (d == "L") {
        if (rFlag) {
          result = "Yes"
        }
      } else {
        rFlag = true
      }
    })
  })

  println(result)
}
