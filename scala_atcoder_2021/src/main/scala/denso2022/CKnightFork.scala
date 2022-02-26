package denso2022

object CKnightFork extends App {
  val xyVector = scala.io.StdIn.readLine().split(" ").map(_.toLong).toVector
  val x1 = xyVector(0)
  val y1 = xyVector(1)
  val x2 = xyVector(2)
  val y2 = xyVector(3)

  var result = "No"
  (x1 - 2 to x1 + 2).foreach(x => {
    (y1 - 2 to y1 + 2).foreach(y => {
      val result1 = (x1 - x) * (x1 - x) + (y1 - y) * (y1 - y)
      val result2 = (x2 - x) * (x2 - x) + (y2 - y) * (y2 - y)
      if (result1 == 5 && result2 == 5) {
        result = "Yes"
      }
    })
  })

  println(result)
}
