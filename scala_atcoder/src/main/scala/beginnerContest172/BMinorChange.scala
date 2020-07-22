package beginnerContest172

// https://atcoder.jp/contests/abc172/tasks/abc172_b

object BMinorChange extends App {
  val s = scala.io.StdIn.readLine()
  val t = scala.io.StdIn.readLine()
  var result = 0
  s.zipWithIndex.foreach { c =>
    if(c._1 != t(c._2)) {
      result = result + 1
    }
  }
  println(result)
}
