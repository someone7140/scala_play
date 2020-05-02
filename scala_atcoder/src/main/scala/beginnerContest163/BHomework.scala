package beginnerContest163

// https://atcoder.jp/contests/abc163/tasks/abc163_b

object BHomework extends App {
  val nm =  scala.io.StdIn.readLine()
  val nmArray = nm.split(" ").map(_.toInt).toSeq
  val n = nmArray(0)
  val m = nmArray(1)
  val aInput =  scala.io.StdIn.readLine()
  val aVecotor = aInput.split(" ").map(_.toInt).toVector

  val sabun = n - aVecotor.sum

  if (sabun >= 0) println(sabun) else println(-1)

}