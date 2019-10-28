package beginnerContest144

// https://atcoder.jp/contests/abc144/tasks/abc144_b

import scala.util.control.Breaks

object B81 extends App {
  val n =  scala.io.StdIn.readInt()
  var result = "No"
  val b = new Breaks
  b.breakable {
    (1 to 9).foreach { i =>
      if (n % i == 0) {
        val i2 = n / i
        if(i2 < 10) {
          result = "Yes"
          b.break
        }
      }
    }
  }
  println(result)
}
