package beginnerContest167

// https://atcoder.jp/contests/abc167/tasks/abc167_b

object BEasyLinearProgramming extends App {
  val abck =  scala.io.StdIn.readLine()
  val abckArray =  abck.split(" ").map(_.toInt).toSeq
  val a = abckArray(0)
  val b = abckArray(1)
  val c = abckArray(2)
  val k = abckArray(3)

  var temp = k
  var result = 0

  if (temp - a <= 0) {
    println(temp)
  } else {
    result = a
    temp = temp - a
    if (temp - b <= 0) {
      println(result)
    } else {
      temp = temp - b
      println(result - temp)
    }
  }
}
