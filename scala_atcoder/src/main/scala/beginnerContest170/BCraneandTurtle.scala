package beginnerContest170

// https://atcoder.jp/contests/abc170/tasks/abc170_b

object BCraneandTurtle extends App {
  val xy =  scala.io.StdIn.readLine()
  val xyArray = xy.split(" ").map(_.toInt).toSeq
  val x = xyArray(0)
  val y = xyArray(1)

  if (y % 2 != 0) {
    println("No")
  } else if (x * 4 < y) {
    println("No")
  } else if (x * 2 > y){
    println("No")
  } else {
    println("Yes")
  }
}
