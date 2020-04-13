package beginnerContest162

// https://atcoder.jp/contests/abc162/tasks/abc162_c

object CSumofgcdofTuples extends App {
  //最大公約数
  def gcd(x: Long, y: Long): Long = {
    if(y == 0) x
    else gcd(y, (x % y))
  }

  val k =  scala.io.StdIn.readInt()
  var result = 0L

  (1 to k).foreach { a =>
    (1 to k).foreach { b =>
      (1 to k).foreach { c =>
        val gcdResult = gcd(gcd(a.toLong, b.toLong), c.toLong)
        if(a == b && a == c && b ==c) {
          result += gcdResult
        } else {
          result += gcdResult
        }

      }
    }
  }
  println(result)
}
