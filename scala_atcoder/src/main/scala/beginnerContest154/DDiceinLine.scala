package beginnerContest154

// https://atcoder.jp/contests/abc154/tasks/abc154_d

object DDiceinLine extends App {
  def getExpect(i: Int): Double = {
    (1 to i).sum.toDouble / i.toDouble
  }
  val nkInput =  scala.io.StdIn.readLine()
  val nkArray = nkInput.split(" ").map(_.toInt).toSeq
  val n = nkArray(0)
  val k = nkArray(1)
  val pInput =  scala.io.StdIn.readLine()
  val pArray = pInput.split(" ").map(_.toInt).toVector

  var prefSum = -1
  var maxSum = -1
  var targetIndex = -1
  var sumTotal = 0

  (0 to n - 1).foreach { i =>
    if (i >= k - 1) {
      var tempSum = 0
      if (prefSum > 0) {
        tempSum = prefSum - pArray(i - k - 1) + pArray(i)
        prefSum = tempSum
      } else {
        (0 to k - 1).foreach { j =>
          tempSum = tempSum + pArray(i - j)
        }
      }
      if(maxSum < tempSum) {
        maxSum = tempSum
        targetIndex = i
      }
    }
  }

  var result = 0d
  (0 to k - 1).foreach { j =>
    result = result + getExpect(pArray(targetIndex - j))
  }

  println(result)

}
