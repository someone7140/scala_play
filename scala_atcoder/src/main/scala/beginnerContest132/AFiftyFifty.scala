package beginnerContest132

// https://atcoder.jp/contests/abc132/tasks/abc132_a

object AFiftyFifty extends App {
  var s = scala.io.StdIn.readLine()
  var result = "Yes"
  s.foreach { c =>
    if(s.count(_ == c) != 2) {
      result = "No"
    }
  }
  println(result)
}