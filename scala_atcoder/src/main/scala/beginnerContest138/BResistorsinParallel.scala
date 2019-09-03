package beginnerContest138

// https://atcoder.jp/contests/abc138/tasks/abc138_b

object BResistorsinParallel extends App {

  //最大公約数
  def gcd(x: Long, y: Long): Long = {
    if(y == 0) x
    else gcd(y, (x % y))
  }

  //最小公倍数
  def lcm(x: Long, y: Long): Long = {
    if(x == 0 || y == 0) 0
    else (x * y) / gcd(x, y)
  }

  val n = scala.io.StdIn.readInt()
  val readA =  scala.io.StdIn.readLine()
  val aArray = readA.split(" ").map(_.toLong).toVector
  var kobaisuu = 1L

  aArray.foreach(a =>
    kobaisuu = lcm(a, kobaisuu)
  )
  val bunshiArray = aArray.map(a => kobaisuu / a)
  println(kobaisuu.toDouble / bunshiArray.sum.toDouble)
}
