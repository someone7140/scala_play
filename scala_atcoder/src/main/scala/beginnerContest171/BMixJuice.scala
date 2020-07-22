package beginnerContest171

// https://atcoder.jp/contests/abc171/tasks/abc171_b

object BMixJuice extends App {
  val nk =  scala.io.StdIn.readLine()
  val nkArray = nk.split(" ").map(_.toInt).toSeq
  val n = nkArray(0)
  val k = nkArray(1)

  val pInput = scala.io.StdIn.readLine()
  val pArray = pInput.split(" ").map(_.toInt).toVector.sorted

  var result = 0
  (0 to k -1).foreach { p =>
    result = result + pArray(p)
  }
  println(result)
}
