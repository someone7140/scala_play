package beginnerContest142

// https://atcoder.jp/contests/abc142/tasks/abc142_c

object CGotoSchool extends App {
  val n =  scala.io.StdIn.readInt()
  val a = scala.io.StdIn.readLine()
  val aArray = a.split(" ").map(_.toInt).toVector
  val resultVec = aArray.zipWithIndex.map{ case(a, i) => (i + 1, a) }.sortBy(_._2).map(_._1)
  println(resultVec.mkString(" "))
}
