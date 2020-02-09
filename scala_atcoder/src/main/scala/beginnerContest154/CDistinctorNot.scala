package beginnerContest154

// https://atcoder.jp/contests/abc154/tasks/abc154_c

object CDistinctorNot extends App {
  val n = scala.io.StdIn.readInt()
  val aInput =  scala.io.StdIn.readLine()
  val lengthAfterDistinct = aInput.split(" ").toVector.distinct.length

  if (n == lengthAfterDistinct) {
    println("YES")
  } else {
    println("NO")
  }
}
