package beginnerContest234

import scala.math.sqrt

object BLongestSegment extends App {
  val n = scala.io.StdIn.readInt()
  val xyArray = new Array[(Double, Double)](n)

  (0 to (n - 1)).foreach(i => {
    val xy = scala.io.StdIn.readLine().split(" ").map(_.toDouble)
    xyArray(i) = (xy(0), xy(1))
  })

  var result = 0d
  (0 to (n - 2)).foreach(i => {
    (i to (n - 1)).foreach(j => {
      val temp = sqrt(
        (xyArray(i)._1 - xyArray(j)._1) * (xyArray(i)._1 - xyArray(j)._1)
        + (xyArray(i)._2 - xyArray(j)._2) * (xyArray(i)._2 - xyArray(j)._2)
      )
      if (temp > result) {
        result = temp
      }
    })
  })

  println(result)
}
