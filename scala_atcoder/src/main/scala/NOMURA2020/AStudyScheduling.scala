package NOMURA2020

// https://atcoder.jp/contests/nomura2020/tasks/nomura2020_a

object AStudyScheduling extends App {
  val hmhmk = scala.io.StdIn.readLine()
  val hmhmkArray = hmhmk.split(" ").map(_.toInt).toSeq
  val start = hmhmkArray(0) * 60 + hmhmkArray(1)
  val end = hmhmkArray(2) * 60 + hmhmkArray(3)
  val k = hmhmkArray(4)

  println(end - start - k)

}
