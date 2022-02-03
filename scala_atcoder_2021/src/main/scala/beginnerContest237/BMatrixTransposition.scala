package beginnerContest237

object BMatrixTransposition extends App {
  val hwVector = scala.io.StdIn.readLine().split(" ").map(_.toInt).toVector
  val h = hwVector(0)
  val w = hwVector(1)
  val aArray = new Array[Array[Int]](h)
  val bArray = new Array[Array[Int]](w)

  (0 to h - 1).foreach(i => {
    val a = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    aArray(i) = a
  })

  (0 to w - 1).foreach(i => {
    val tempBArray = new Array[Int](h)
    (0 to h - 1).foreach(j => {
      tempBArray(j) = aArray(j)(i)
    })
    bArray(i) = tempBArray
  })

  val result = bArray.map(_.mkString(" ")).mkString(System.lineSeparator)
  println(result)
}
