package beginnerContest169

// https://atcoder.jp/contests/abc169/tasks/abc169_a

object AMultiplication1 extends App {
  val ab =  scala.io.StdIn.readLine()
  val abArray = ab.split(" ").map(_.toInt).toSeq
  println(abArray(0) * abArray(1))

}
