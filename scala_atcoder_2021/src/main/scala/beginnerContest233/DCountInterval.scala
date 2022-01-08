package beginnerContest233

object DCountInterval extends App {
  val nkVector = scala.io.StdIn.readLine().split(" ").map(_.toLong).toVector
  val n = nkVector(0)
  val k = nkVector(1)

  val aArray = scala.io.StdIn.readLine().split(" ").map(_.toLong)
  var aVec = Vector.empty[Long]
  var result = 0L
  var tempSumA = aArray(0)
  aVec :+= aArray(0)

  def calc(inputVec: Vector[Long], sum: Long, index: Int): Unit = {
    if (sum == k) {
      result = result + 1
    }
    if (index < n) {
      var tempSum = 0L
      var tempVec = Vector.empty[Long]
      val nextA = aArray(index)
      if (nextA == k) {
        result = result + 1
      }
      inputVec.reverse.foreach(input => {
        tempVec :+= input
        tempSum = tempSum + input
        calc(tempVec ++ Vector(nextA), tempSum + nextA, index + 1)
      })
    }
  }
  if (tempSumA == k) {
    result = result + 1
  }
  calc(aVec, tempSumA, 1)

  println(result)
}
