package beginnerContest169

// https://atcoder.jp/contests/abc169/tasks/abc169_b

object BMultiplication2 extends App {
  val n = scala.io.StdIn.readInt()
  val a = scala.io.StdIn.readLine()
  var result = 1L
  val max = 1000000000000000000L
  a.split(" ").map(_.toLong).sorted.foreach { n =>
    if (result != 0L && result != -1L) {
      if (Math.log10(n.toDouble) + Math.log10(result.toDouble) > 18.1d) {
        result = -1
      } else {
        result = result * n
        // println(result)
        if (result > max) {
          result = -1L
        } else if (result < 0L) {
          result = -1L
        }
      }
    }
  }
  println(result)
}
