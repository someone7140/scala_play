package beginnerContest200

object CRingosFavoriteNumbers2 extends App {
  val n = scala.io.StdIn.readInt();
  val aInput = scala.io.StdIn.readLine()
  val aVector = aInput.split(" ").map(_.toLong).toVector

  var result = 0L

  val amariArray = new Array[Long](200)

  aVector.foreach(a => {
    val amari = (a % 200).toInt
    amariArray(amari) = amariArray(amari) + 1L
  })

  (0 to 199).foreach(i => {
    val amariCount = amariArray(i)
    if (amariCount > 1) {
      val count = amariCount * (amariCount - 1L) / 2L
      result += count
    }
  })

  println(result)

}
