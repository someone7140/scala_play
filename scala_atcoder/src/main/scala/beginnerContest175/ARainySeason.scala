package beginnerContest175

// https://atcoder.jp/contests/abc175/tasks/abc175_a

object ARainySeason extends App {
  val s = scala.io.StdIn.readLine()
  var result = 0
  if (s == "SSS") {
    result = 0
  } else if (s == "RRR") {
    result = 3
  } else if (s == "RRS" || s == "SRR") {
    result = 2
  } else {
    result = 1
  }
  println(result)
}
