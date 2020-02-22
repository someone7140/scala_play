package beginnerContest156

// https://atcoder.jp/contests/abc156/tasks/abc156_c

object BDigits extends App {
  val nkInput =  scala.io.StdIn.readLine()
  val nkArray = nkInput.split(" ").map(_.toInt).toSeq
  val n = nkArray(0).toDouble
  val k = nkArray(1).toDouble
  if(n <= 1) {
    println(1)
  } else {
    val log = Math.log(n) / Math.log(k)
    println(Math.ceil(log).toInt)
  }
}
