package beginnerContest236

object BWhoismissing extends App {
  val n = scala.io.StdIn.readInt()
  val aMapVector = scala.io.StdIn.readLine().split(" ").map(a => a.toInt -> 1).toVector

  val result = aMapVector.groupBy(_._1).view.mapValues(_.foldLeft(0)(_ + _._2)).filter(a => a._2 < 4).toVector(0)._1
  println(result)

}
