package beginnerContest161

// https://atcoder.jp/contests/abc161/tasks/abc161_c

object CReplacingInteger extends App {
  val nk =  scala.io.StdIn.readLine()
  val nkArray = nk.split(" ").map(_.toLong).toSeq
  val n = nkArray(0)
  val k = nkArray(1)

  val amari = n % k
  val amariMinusK = Math.abs(n % k - k)

  println(if(amariMinusK < amari) amariMinusK else amari)
}
