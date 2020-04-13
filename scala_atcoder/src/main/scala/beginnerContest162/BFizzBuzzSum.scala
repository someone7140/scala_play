package beginnerContest162

// https://atcoder.jp/contests/abc162/tasks/abc162_b

object BFizzBuzzSum extends App {
  val n =  scala.io.StdIn.readInt()
  var result = 0L

  (1 to n).foreach { i =>
    if (i % 3 != 0 && i % 5!= 0) {
      result = result + i.toLong
    }
  }

  println(result)

}
