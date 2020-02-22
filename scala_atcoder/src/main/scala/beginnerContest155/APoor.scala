package beginnerContest155

// https://atcoder.jp/contests/abc155/tasks/abc155_a

object APoor extends App {
  val abcInput =  scala.io.StdIn.readLine()
  val abcArray = abcInput.split(" ").map(_.toInt).toSeq
  val distinctAbc = abcArray.distinct
  if (distinctAbc.length == 2) {
    println("Yes")
  } else {
    println("No")
  }

}
