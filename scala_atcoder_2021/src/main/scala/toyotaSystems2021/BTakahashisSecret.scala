package toyotaSystems2021

object BTakahashisSecret extends App {
  val nxVector = scala.io.StdIn.readLine().split(" ").map(_.toInt).toVector
  val n = nxVector(0)
  val x = nxVector(1)

  val aArray = scala.io.StdIn.readLine().split(" ").map(_.toInt)
  var aVisitedArray = Array.fill[Boolean](n)(false)
  var result = 0
  var loopFlag = true
  var targetIndex = x - 1

  while (loopFlag) {
    if (!aVisitedArray(targetIndex)) {
      result = result + 1
      aVisitedArray(targetIndex) = true
      targetIndex = aArray(targetIndex) - 1
    } else {
      loopFlag = false
    }
  }
  println(result)
}
