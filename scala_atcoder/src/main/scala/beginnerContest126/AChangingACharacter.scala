package beginnerContest126

// https://atcoder.jp/contests/abc126/tasks/abc126_a

object AChangingACharacter extends App {
  val read = scala.io.StdIn.readLine()
  val array =  read.split(" ").map(_.toInt).toVector
  val n = array(0)
  val k = array(1)
  val s = scala.io.StdIn.readLine()
  val result = s.zipWithIndex.map {case (c, i) =>
    if ((k-1) == i) {
      if (Character.isUpperCase(c) ) {
        c.toString.toLowerCase
      } else {
        c.toString.toUpperCase
      }
    } else {
      c.toString
    }
  }.mkString
  print(result)
}
