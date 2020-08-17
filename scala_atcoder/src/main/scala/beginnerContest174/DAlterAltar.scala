package beginnerContest174

// https://atcoder.jp/contests/abc174/tasks/abc174_d

object DAlterAltar extends App {
  val n =  scala.io.StdIn.readInt()
  val c =  scala.io.StdIn.readLine()

  val wCount = c.count(cc => cc == 'W')
  val rCount = n - wCount

  if (wCount == 0 || rCount == 0) {
    println(0)
  } else {
    val countMin = if (wCount > rCount) rCount else wCount
    var tempCount = 0
    var findWCount = 0
    var plusCount = 0
    c.foreach { cc =>
      if (cc == 'W') {
        findWCount = findWCount + 1
      } else {
        if (findWCount > 0) {
          tempCount = tempCount + 1
          findWCount = findWCount - 1
        }
      }
    }
    val tempResult = tempCount + plusCount
    val result = if (countMin < tempResult) countMin else tempResult
    println(result)
  }
}
