package beginnerContest116

// https://atcoder.jp/contests/abc116/tasks/abc116_a

object ARightTriangle extends App {
  var s = scala.io.StdIn.readLine()
  val inputArray =  s.split(" ")
  println(inputArray(0).toInt * inputArray(1).toInt / 2)
}