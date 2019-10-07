package beginnerContest142

// https://atcoder.jp/contests/abc142/tasks/abc142_a

object AOddsofOddness extends App {
  val n =  scala.io.StdIn.readInt()
  println((1 to n).filter(_ % 2 != 0).size.toDouble / n.toDouble)
}
