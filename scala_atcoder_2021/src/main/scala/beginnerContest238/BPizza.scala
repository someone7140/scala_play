package beginnerContest238

object BPizza extends App {
  val n = scala.io.StdIn.readInt()
  val aVector = scala.io.StdIn.readLine().split(" ").map(_.toInt).toVector

  var kakudoArray = Array.fill[Int](n + 1)(-1)
  val initial = aVector(0)
  kakudoArray(0) = 0
  kakudoArray(1) = initial

  aVector.tail.foreach(a => {
    val kakudoNextArray = Array.fill[Int](n + 1)(-1)
    kakudoNextArray(0) = 0
    kakudoArray.zipWithIndex.foreach(kakudo => {
      if (kakudo._1 > -1) {
        var temp = kakudo._1 + a
        if (temp > 360) {
          temp = temp - 360
        }
        kakudoNextArray(kakudo._2 + 1) = temp
      }
    })
    val tempArray = kakudoNextArray.filter(k => k != -1).sorted
    tempArray.zipWithIndex.foreach(t => {
      kakudoArray(t._2) = tempArray(t._2)
    })
  })

  var result = -1
  val loopMax = kakudoArray.length - 1
  (0 to loopMax).foreach(i => {
    var temp = -1
    if (i == loopMax) {
      temp = 360 - kakudoArray(i)
    } else {
      temp = kakudoArray(i + 1) - kakudoArray(i)
    }

    if (result < temp) {
      result = temp
    }
  })
  println(result)

}
