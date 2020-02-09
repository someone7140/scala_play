package beginnerContest153

// https://atcoder.jp/contests/abc153/tasks/abc153_b

object BCommonRaccoonvsMonster extends App {
  val hn = scala.io.StdIn.readLine()
  val hnArray = hn.split(" ").map(_.toLong).toVector
  val h = hnArray(0)
  val n = hnArray(1)
  val a = scala.io.StdIn.readLine()
  val aArray = a.split(" ").map(_.toLong).toVector
  val aArraySum = aArray.sum

  println(if(aArraySum >= h) "Yes" else "No")
}
