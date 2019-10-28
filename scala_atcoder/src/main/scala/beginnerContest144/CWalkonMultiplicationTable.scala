package beginnerContest144

// https://atcoder.jp/contests/abc144/tasks/abc144_c

import scala.util.control.Breaks

object CWalkonMultiplicationTable extends App {
  val n =  scala.io.StdIn.readLong()
  val max = math.sqrt(n).toInt
  val b = new Breaks
  var coordinate = (1L, n)
  b.breakable {
    for (i <- max to 2 by -1) {
      if (n % i == 0) {
        coordinate = (i.toLong, n / i)
        b.break
      }
    }
  }
  println(coordinate._1 + coordinate._2 - 2L)
}
