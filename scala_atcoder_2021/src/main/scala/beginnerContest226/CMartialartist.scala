package beginnerContest226

object CMartialartist extends App {
  val n = scala.io.StdIn.readInt()
  var taArray = new Array[(BigInt, Set[Int])](n)
  var result = BigInt(0)

  (0 to n - 1).foreach(i => {
    val taVector = scala.io.StdIn.readLine().split(" ").map(_.toInt).toVector
    val t = BigInt(taVector.head)
    val count = taVector(1)
    if (count == 0) {
      taArray(i) = (t, Set.empty[Int])
    } else {
      taArray(i) = (t, taVector.drop(2).toSet)
    }
  })

  var indexSet = Set.empty[Int]
  def resultCalc(index: Int): Unit = {
    val ta = taArray(index)
    result += ta._1
    if (!ta._2.isEmpty) {
      val sabun = ta._2 diff indexSet
      indexSet = indexSet ++ sabun
      sabun.foreach(i => {
        resultCalc(i - 1)
      })
    }
  }
  indexSet += n
  resultCalc(n - 1)

  println(result)
}
