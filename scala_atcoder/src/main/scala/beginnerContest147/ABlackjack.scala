package beginnerContest147

// https://atcoder.jp/contests/abc147/tasks/abc147_a

object ABlackjack extends App {
  val aInput = scala.io.StdIn.readLine()
  val aSum = aInput.split(" ").map(_.toInt).toSeq.sum
  println(if (aSum >= 22) "bust" else "win")
}
