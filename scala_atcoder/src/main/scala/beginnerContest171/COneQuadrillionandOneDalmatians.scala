package beginnerContest171

// https://atcoder.jp/contests/abc171/tasks/abc171_c

import scala.util.control.Breaks

object COneQuadrillionandOneDalmatians extends App {
  val n =  scala.io.StdIn.readLong()
  var upper26Count = 0L
  var upper26Sum = 1L
  var kakeruCount = 1L

  val b = new Breaks
  b.breakable {
    while(true) {
      upper26Count = upper26Count + 1L
      var plus = 1L
      (1L to kakeruCount).foreach { k =>
        plus = plus * 26
      }
      upper26Sum =  if(upper26Sum == 1L) plus else upper26Sum + plus
      kakeruCount = kakeruCount + 1L
      if (upper26Sum >= n) {
        b.break()
      }
    }
  }

  var tempUpper26Sum = n
  var result = ""
  (0L to upper26Count - 1L).foreach { i =>
    val amari = tempUpper26Sum % 26L
    val charIndex = if (amari == 0L) 26L else amari
    result = (charIndex + 96L).toChar.toString + result

    if (amari != 0L) {
      tempUpper26Sum = tempUpper26Sum / 26
    } else {
      var minus = 26L
      (0L to i - 1).foreach { _ =>
        minus = minus + minus * 26
      }
      tempUpper26Sum = tempUpper26Sum - minus
    }
  }
  println(result)
}
