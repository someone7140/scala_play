package disco2020

// https://atcoder.jp/contests/ddcc2020-qual/tasks/ddcc2020_qual_a

object ADDCCFinals extends App {
  val xy = scala.io.StdIn.readLine()
  val xyArray = xy.split(" ").map(_.toInt).toVector
  val x = xyArray(0)
  val y = xyArray(1)
  var sum = 0
  if (x == 1) {
    sum += 300000
  } else  if (x == 2) {
    sum += 200000
  } else  if (x == 3) {
    sum += 100000
  }

  if (y == 1) {
    sum += 300000
  } else  if (y == 2) {
    sum += 200000
  } else  if (y == 3) {
    sum += 100000
  }

  if (x == 1 && y == 1) {
    sum += 400000
  }

  println(sum)
}
