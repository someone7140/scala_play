package beginnerContest155

// https://atcoder.jp/contests/abc155/tasks/abc155_b

object BPapersPlease extends App {
  val n = scala.io.StdIn.readInt()
  val aInput = scala.io.StdIn.readLine()
  val aArray = aInput.split(" ").map(_.toInt).toVector

  var result = "APPROVED"
  aArray.foreach { a =>
    if (a % 2 == 0) {
      if (a % 3 != 0 && a % 5 != 0) {
        result = "DENIED"
      }
    }

  }
  println(result)

}
