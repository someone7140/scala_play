package beginnersSelection

// https://atcoder.jp/contests/abs/tasks/abc081_a

object Abc081aPlacingMarbles extends App {
  var s = scala.io.StdIn.readLine()
  var count = 0
  for (i <- 0 to 2) {
    if (s(i) == '1') {
      count += 1
    }
  }
  println(count)
}