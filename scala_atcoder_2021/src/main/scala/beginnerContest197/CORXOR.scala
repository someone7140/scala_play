package beginnerContest197

object CORXOR extends App {
  val n = scala.io.StdIn.readInt();
  val aInput = scala.io.StdIn.readLine()
  val aVector = aInput.split(" ").map(_.toLong).toVector

  var result = 222222222222L

  def getOr(orVector: Vector[Long]): Long = {
    orVector.reduceLeft((z, n) => z | n)
  }

  def judgeResult(targetVector: Vector[Vector[Long]]): Unit = {
    val xor = targetVector.map(getOr).reduce((z, n) => z ^ n)
    if (xor < result) {
      result = xor
    }
  }
  def split(targetVector: Vector[Vector[Long]], splitIndex: Int, count: Int): Unit = {
    if (count < n) {
      // そのまま
      split(targetVector, splitIndex + 1, count + 1)
      // 分割
      var newTargetVector = targetVector.dropRight(1)
      val lastVector = targetVector.last
      val lastSplit = lastVector.splitAt(splitIndex)
      newTargetVector :+= lastSplit._1
      newTargetVector :+= lastSplit._2
      judgeResult(newTargetVector)
      split(newTargetVector, 1, count + 1)
    }


  }
  var vecVec = Vector.empty[Vector[Long]]
  vecVec :+= aVector
  judgeResult(vecVec)
  split(vecVec, 1, 1)
  println(result)

}
