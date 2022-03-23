package beginnerContest243

object AShampoo extends App {
  val vabcVector = scala.io.StdIn.readLine().split(" ").map(_.toInt).toVector
  val v = vabcVector(0)
  val a = vabcVector(1)
  val b = vabcVector(2)
  val c = vabcVector(3)

  var loopFlag = true
  var result = "F"
  var tempV = v
  var index = 1

  while (loopFlag) {
    val target = index % 3
    if (target == 1) {
      result = "F"
      if (tempV >= a) {
        tempV = tempV - a
        index = index + 1
      } else {
        loopFlag = false

      }
    } else if (target == 2) {
      result = "M"
      if (tempV >= b) {
        tempV = tempV - b
        index = index + 1
      } else {
        loopFlag = false
      }
    } else {
      result = "T"
      if (tempV >= c) {
        tempV = tempV - c
        index = index + 1
      } else {
        loopFlag = false
      }
    }
  }
  println(result)

}
