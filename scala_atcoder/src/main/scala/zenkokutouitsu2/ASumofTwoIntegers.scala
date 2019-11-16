package zenkokutouitsu2

// https://atcoder.jp/contests/nikkei2019-2-qual/tasks/nikkei2019_2_qual_a

object ASumofTwoIntegers extends App {
  val n =  scala.io.StdIn.readInt()
  val target = if (n % 2 == 0) n else n + 1
  println(target / 2 - 1)
}
