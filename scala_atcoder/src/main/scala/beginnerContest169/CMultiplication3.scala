package beginnerContest169

// https://atcoder.jp/contests/abc169/tasks/abc169_c

object CMultiplication3 extends App {
  val ab = scala.io.StdIn.readLine()
  val abArray = ab.split(" ")

  val a = abArray(0).toLong
  val b = if (abArray(1).toDouble == 0d) { 0L } else {
    abArray(1).replaceAll("0\\.0", "").replaceAll("0\\.", "").replaceAll("\\.", "").toLong
  }
  println(a / 100L * b + a % 100L * b / 100L)
}
