package beginnerContest153

// https://atcoder.jp/contests/abc153/tasks/abc153_c

object CFennecvsMonster extends App {
  val nk = scala.io.StdIn.readLine()
  val nkArray = nk.split(" ").map(_.toInt).toVector
  val n = nkArray(0)
  val k = nkArray(1)
  val h = scala.io.StdIn.readLine()
  val hArray = h.split(" ").map(_.toLong).toVector.sorted.reverse
  if(k >= n) {
    println(0)
  } else {
    val countArray = hArray.drop(k)
    println(countArray.sum)
  }
}
