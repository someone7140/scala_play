package beginnerContest156

// https://atcoder.jp/contests/abc156/tasks/abc156_a

object ABeginner extends App {
  val nrInput =  scala.io.StdIn.readLine()
  val nrArray = nrInput.split(" ").map(_.toInt).toSeq
  val n = nrArray(0)
  val r = nrArray(1)
  if (n >= 10) {
    println(r)
  } else {
    println((10 - n) * 100 + r)
  }

}
