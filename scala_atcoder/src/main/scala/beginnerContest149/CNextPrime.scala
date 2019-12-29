package beginnerContest149

// https://atcoder.jp/contests/abc149/tasks/abc149_c

import scala.util.control.Breaks

object CNextPrime extends App {
  def isPrime(n: Int): Boolean = {
    if (n < 2 || (n > 2 && n % 2 == 0)) {
      return false
    } else if (n == 2) {
      return true
    }
    for (i <- 3 to Math.sqrt(n).toInt by 2 ) {
      if (n % i == 0) {
        return false
      }
    }
    return true
  }

  var x = scala.io.StdIn.readInt()
  val b = new Breaks
  b.breakable {
    while(true) {
      if(isPrime(x)) {
        b.break()
      } else {
        x = x + 1
      }
    }
  }
  println(x)
}
