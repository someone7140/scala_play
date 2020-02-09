package beginnerContest153

// https://atcoder.jp/contests/abc153/tasks/abc153_a

object AServalvsMonster extends App {
  val ha = scala.io.StdIn.readLine()
  val haArray = ha.split(" ").map(_.toInt).toVector
  val h = haArray(0)
  val a = haArray(1)

  val amari = h % a
  println(if(amari > 0) h/a + 1 else h/a)
}
