package beginnerContest147

// https://atcoder.jp/contests/abc147/tasks/abc147_b

object BPalindromephilia extends App {
  val s = scala.io.StdIn.readLine()
  val sReverse = s.reverse
  var result = 0
  s.zipWithIndex.foreach(c =>
    if(sReverse(c._2) != c._1) {
      result += 1
    }
  )
  println(result / 2)
}
