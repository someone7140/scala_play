package beginnerContest148

// https://atcoder.jp/contests/abc148/tasks/abc148_a

object ARoundOne extends App {
  val a = scala.io.StdIn.readInt()
  val b = scala.io.StdIn.readInt()
  if ((a == 1 && b == 2) || (a == 2 && b == 1)) {
    println(3)
  } else if((a == 1 && b == 3) || (a == 3 && b == 1))  {
    println(2)
  } else {
    println(1)
  }

}
