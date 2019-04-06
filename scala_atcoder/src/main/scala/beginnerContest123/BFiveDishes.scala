package beginnerContest123

// https://atcoder.jp/contests/abc123/tasks/abc123_b

object BFiveDishes extends App {
  var array = Vector.empty[Int]
  var k = 0
  for(i<-1 to 5) {
    array :+= scala.io.StdIn.readInt()
  }
  val arrayTurple = array.map {d =>
    (d, if (d % 10 == 0) 0 else 10 - (d % 10))
  }
  val sum = arrayTurple.sortBy(_._2).zipWithIndex.map {case (a, index) =>
    if (index == 4) {
      a._1
    } else {
      a._1 + a._2
    }
  }.sum
  println(sum)
}