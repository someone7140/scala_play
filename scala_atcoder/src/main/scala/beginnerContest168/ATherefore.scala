package beginnerContest168

// https://atcoder.jp/contests/abc168/tasks/abc168_a

object ATherefore extends App {
  val n =  scala.io.StdIn.readLine()
  val matsubi = n.last.toString.toInt
  if (matsubi == 3) {
    println("bon")
  } else if (matsubi == 0 || matsubi == 1 || matsubi == 6 || matsubi == 8) {
    println("pon")
  } else {
    println("hon")
  }

}
