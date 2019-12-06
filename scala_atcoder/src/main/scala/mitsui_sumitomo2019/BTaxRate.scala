package mitsui_sumitomo2019

// https://atcoder.jp/contests/sumitrust2019/tasks/sumitb2019_b

object BTaxRate extends App {
  val n =  scala.io.StdIn.readInt()
  val zeinukiKiriage = math.ceil(n / 1.08)
  val zeinukiKirisage = math.floor(n / 1.08)
  val judge1 = zeinukiKiriage * 1.08
  val judge2 = zeinukiKirisage * 1.08
  if (judge1 < (n + 1) && judge1 >= n) {
    println(zeinukiKiriage.toInt)
  } else if (judge2 < (n + 1) && judge2 >= n) {
    println(zeinukiKirisage.toInt)
  } else {
    println(":(")
  }
}
