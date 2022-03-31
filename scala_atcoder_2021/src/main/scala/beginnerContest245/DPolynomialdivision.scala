package beginnerContest245

object DPolynomialdivision extends App {
  val nmArray = scala.io.StdIn.readLine().split(" ").map(_.toInt)
  val n = nmArray(0)
  val m = nmArray(1)
  val nm = n + m

  val aArray = scala.io.StdIn.readLine().split(" ").map(_.toInt)
  val cArray = scala.io.StdIn.readLine().split(" ").map(_.toInt)

  val bArray = new Array[Int](m + 1)

  var lastA = -999

  (0 to nm).foreach(i =>
    if (i == 0) {
      lastA = aArray(i)
      bArray(i) = cArray(i) / aArray(i)
    } else if (i == nm) {
      bArray(i) = cArray(i + 1) / lastA
    } else {
      lastA = aArray(i)
      val beforeB = bArray(i - 1)
      bArray(i) = (cArray(i) - beforeB * aArray(i)) / aArray(i - 1)
    }
  )

  println(bArray.mkString(" "))
}
