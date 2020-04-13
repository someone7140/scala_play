package beginnerContest160

// https://atcoder.jp/contests/abc160/tasks/abc160_b

object BGoldenCoins extends App {
  val x = scala.io.StdIn.readInt()

  var ureshisa = x / 500 * 1000 + (x % 500 / 5 * 5)
  println(ureshisa)
}
