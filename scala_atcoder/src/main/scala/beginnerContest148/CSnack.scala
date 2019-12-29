package beginnerContest148

// https://atcoder.jp/contests/abc148/tasks/abc148_c

object CSnack extends App {
  //最大公約数
  def gcd(x: Int, y: Int): Int = {
    if(y == 0) x
    else gcd(y, (x % y))
  }
  //最小公倍数
  def lcm(x: Int, y: Int): Long = {
    if(x == 0 || y == 0) 0
    else (x.toLong * y.toLong) / gcd(x, y).toLong
  }

  val ab = scala.io.StdIn.readLine()
  val abArray = ab.split(" ").map(_.toInt).toVector
  println(lcm(abArray(0), abArray(1)))

}
