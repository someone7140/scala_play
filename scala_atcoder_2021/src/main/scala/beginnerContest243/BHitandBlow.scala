package beginnerContest243

object BHitandBlow extends App {
  val n = scala.io.StdIn.readInt()
  val aArray = scala.io.StdIn.readLine().split(" ").map(_.toInt)
  val bArray = scala.io.StdIn.readLine().split(" ").map(_.toInt)

  var result1 = 0

  aArray.zipWithIndex.foreach(a => {
    if (a._1 == bArray(a._2)) {
      result1 = result1 + 1
    }
  })
  var result2 = aArray.intersect(bArray).size - result1

  println(result1)
  println(result2)
}
