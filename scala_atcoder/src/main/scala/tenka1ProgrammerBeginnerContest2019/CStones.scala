package tenka1ProgrammerBeginnerContest2019

// https://atcoder.jp/contests/tenka1-2019-beginner/tasks/tenka1_2019_c

import scala.util.control.Breaks

object CStones extends App {
  var n = scala.io.StdIn.readInt()
  val s = scala.io.StdIn.readLine()
  var target = s
  target = target.replaceAll("#\\.#", "##").replaceAll("#\\.", "#")
  print(s.length - target.length)
}
