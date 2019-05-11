package diverta2019ProgrammingContest

// https://atcoder.jp/contests/diverta2019/tasks/diverta2019_a

object AConsecutiveIntegers extends App {
  var read = scala.io.StdIn.readLine()
  val array =  read.split(" ").map(_.toInt).toVector
  val n = array(0)
  val k = array(1)
  print(n - k + 1)
}
