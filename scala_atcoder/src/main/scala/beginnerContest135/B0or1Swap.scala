package beginnerContest135

// https://atcoder.jp/contests/abc135/tasks/abc135_b

object BOrdinaryNumber extends App {
  val n = scala.io.StdIn.readInt()
  val read = scala.io.StdIn.readLine()
  val array =  read.split(" ").map(_.toInt).toVector
  val array_sorted = array.sorted
  var diff = 0
  array.zipWithIndex.foreach { case (j, index) =>
    if(j != array_sorted(index)) {
      diff = diff + 1
    }
  }
  if (diff <= 2) {
    println("YES")
  } else {
    println("NO")
  }
}
