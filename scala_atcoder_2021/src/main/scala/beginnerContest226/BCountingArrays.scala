package beginnerContest226

object BCountingArrays extends App {
  val n = scala.io.StdIn.readInt()
  var aVecVec = Vector.empty[Vector[Int]]
  (1 to n).foreach(_ => {
    val aVector = scala.io.StdIn.readLine().split(" ").map(_.toInt).toVector.tail
    aVecVec :+= aVector
  })
  println(aVecVec.distinct.size)
}
