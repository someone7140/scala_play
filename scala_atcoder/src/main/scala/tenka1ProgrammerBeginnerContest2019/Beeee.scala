package tenka1ProgrammerBeginnerContest2019

// https://atcoder.jp/contests/tenka1-2019-beginner/tasks/tenka1_2019_b

object Beeee extends App {
  var n = scala.io.StdIn.readInt()
  var s = scala.io.StdIn.readLine()
  var k = scala.io.StdIn.readInt()

  val word = s.charAt(k - 1)
  val answer = s.map { c =>
    if (c == word) {
      c
    } else {
      "*"
    }
  }.mkString
  print(answer)
}
