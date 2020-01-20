package beginnerContest152

// https://atcoder.jp/contests/abc152/tasks/abc152_a

object AACWA extends App {
  val nmInput = scala.io.StdIn.readLine()
  val nmArray = nmInput.split(" ").map(_.toInt).toSeq
  println(if (nmArray(0) ==  nmArray(1)) "Yes" else "No")
}
