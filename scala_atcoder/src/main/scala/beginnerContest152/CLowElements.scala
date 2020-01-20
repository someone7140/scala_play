package beginnerContest152

// https://atcoder.jp/contests/abc152/tasks/abc152_c

object CLowElements extends App {
  val n = scala.io.StdIn.readInt()
  val pInput = scala.io.StdIn.readLine()
  val pArray = pInput.split(" ").map(_.toInt).toVector
  var target = pArray.head
  var compareArray = pArray.tail
  var tempResult = 0

  var maxKey = 0
  var result = 1

  compareArray.foreach { p =>
    if (target > p) {
      result = result + 1
      target = p
    }
  }
  println(result)
}
