package beginnerContest168

// https://atcoder.jp/contests/abc168/tasks/abc168_b

object BTripleDots extends App {
  val k = scala.io.StdIn.readInt()
  val s = scala.io.StdIn.readLine()
  if (s.length > k) {
    println(s.substring(0, k) + "...")
  } else {
    println(s)
  }

}
