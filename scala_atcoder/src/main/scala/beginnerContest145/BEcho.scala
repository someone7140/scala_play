package beginnerContest145

// https://atcoder.jp/contests/abc145/tasks/abc145_b

object BEcho extends App {
  val n =  scala.io.StdIn.readInt()
  val s = scala.io.StdIn.readLine()
  if (n % 2 == 0) {
    val splitLength = n / 2
    val before = s dropRight splitLength
    val after = s drop splitLength
    if (before == after) {
      println("Yes")
    } else {
      println("No")
    }
  } else {
    println("No")
  }
}

