package beginnerContest125

// https://atcoder.jp/contests/abc125/tasks/abc125_b

object BResale extends App {
  val n = scala.io.StdIn.readInt()
  var vInput = scala.io.StdIn.readLine()
  var cInput = scala.io.StdIn.readLine()
  val vArray =  vInput.split(" ").map(_.toInt).toVector
  val cArray =  cInput.split(" ").map(_.toInt).toVector
  val benefitTuple = vArray.zipWithIndex.map { case (v, i) =>
    v - cArray(i)
  }
  val max = benefitTuple.filter(_ > 0).sum
  print(max)
}
