package beginnerContest132

// https://atcoder.jp/contests/abc132/tasks/abc132_b

object BOrdinaryNumber extends App {
  val n = scala.io.StdIn.readInt()
  val read = scala.io.StdIn.readLine()
  val array =  read.split(" ").map(_.toInt).toVector
  var count = 0
  (0 to (array.size - 3)).foreach { i =>
    val slice = array.slice(i, i + 3)
    if (slice.distinct.count(_ > slice(1)) == 1){
      count = count + 1
    }

  }
  println(count)
}