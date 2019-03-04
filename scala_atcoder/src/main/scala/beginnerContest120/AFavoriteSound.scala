package beginnerContest120

// https://atcoder.jp/contests/abc120/tasks/abc120_a

object AFavoriteSound extends App {
  var input = scala.io.StdIn.readLine()
  val abcArray =  input.split(" ").map(_.toInt)
  val divide = abcArray(1) / abcArray(0)
  if (divide > abcArray(2)) {
    print(abcArray(2))
  } else {
    print(divide)
  }
}
