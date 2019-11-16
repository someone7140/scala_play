package zenkokutouitsu2

// https://atcoder.jp/contests/nikkei2019-2-qual/tasks/nikkei2019_2_qual_b

object BCountingofTrees extends App {
  val n =  scala.io.StdIn.readInt()
  val d = scala.io.StdIn.readLine()
  val dArray = d.split(" ").map(_.toLong).toVector
  if(dArray(0) != 0L) {
    println(0)
  } else {
    println(dArray.tail.foldLeft(1L) { case (sum, d) =>
      if ( d == 0L) {
        sum * 0L
      } else {
        sum * d % 998244353L
      }
    })
  }
}
