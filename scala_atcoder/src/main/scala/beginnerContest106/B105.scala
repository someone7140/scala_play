package beginnerContest106

// https://atcoder.jp/contests/abc106/tasks/abc106_b

object B105 extends App {
  val n = scala.io.StdIn.readInt()
  val result = (1 to n).filter(i => i % 2 != 0).filter { k =>
    (1 to k).filter(l => k % l == 0).size == 8
  }.size
  println(result)
}
