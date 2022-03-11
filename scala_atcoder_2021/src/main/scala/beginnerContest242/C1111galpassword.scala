package beginnerContest242

import scala.annotation.tailrec

object C1111galpassword extends App {
  val n = scala.io.StdIn.readInt()

  var result = 0L

  @tailrec
  def judge(nums: Set[Int], nowCount: Int, tempResult: Long): Unit = {
    if (nowCount == n) {
      result = (result + tempResult) % 998244353L
    } else {
      var temp = tempResult
      val nexts = nums.flatMap(n => {
        if (n == 1) {
          temp = temp + 2
          Array(1, 2)
        } else if (n == 9) {
          temp = temp + 2
          Array(8, 9)
        } else {
          temp = temp + 3
          Array(n - 1, n, n + 1)
        }
      })
      judge(nexts, nowCount + 1, temp)
    }
  }

  judge((1 to 9).toArray.toSeq.toSet, 1, 1L)
  println(result)
}
