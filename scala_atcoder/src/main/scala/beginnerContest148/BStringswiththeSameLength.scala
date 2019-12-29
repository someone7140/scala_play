package beginnerContest148

// https://atcoder.jp/contests/abc148/tasks/abc148_b

object BStringswiththeSameLength extends App {
  val n = scala.io.StdIn.readInt()
  val stInput = scala.io.StdIn.readLine()
  val stArray =  stInput.split(" ")
  val s = stArray(0)
  val t = stArray(1)
  var result = ""

  (0 to (n-1)).foreach { i =>
    result += s(i).toString + t(i).toString
  }
  println(result)

}
