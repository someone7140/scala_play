package beginnerContest142

// https://atcoder.jp/contests/abc142/tasks/abc142_d

object DDisjointSetofCommonDivisors extends App {
  //最大公約数
  def gcd(x: Long, y: Long): Long = {
    if(y == 0) x
    else gcd(y, (x % y))
  }

  val ab = scala.io.StdIn.readLine()
  val abArray = ab.split(" ").map(_.toLong).toVector
  val maxKouyaku = gcd(abArray(0), abArray(1))
  var resultList = Vector.empty[Long]
  (1L to maxKouyaku).filter(v =>  maxKouyaku % v == 0).foreach { v =>
    if (resultList.isEmpty) {
      resultList :+= v
    } else {
      if (resultList.tail.find(r => v % r == 0).isEmpty) {
        resultList :+= v
      }
    }
  }
  println(resultList.size)
}
