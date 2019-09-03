package beginnerContest138

// https://atcoder.jp/contests/abc138/tasks/abc138_a

object ARedorNot extends App {
  val a = scala.io.StdIn.readInt()
  val s =  scala.io.StdIn.readLine()
  println(
    if (a >= 3200)
      s
    else
      "red"
  )
}
