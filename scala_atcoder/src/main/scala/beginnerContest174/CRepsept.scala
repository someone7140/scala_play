package beginnerContest174

// https://atcoder.jp/contests/abc174/tasks/abc174_c

import scala.util.control.Breaks

object CRepsept extends App {
  val max = 1000000000000L
  val k =  scala.io.StdIn.readLong()
  var sevenString = "7"
  var temp = 7L
  var findFlg = false
  val b = new Breaks

  b.breakable {
    while(temp <= max) {
      temp = sevenString.toLong
      findFlg = temp % k == 0
      if (findFlg) {
        b.break()
      }
      sevenString = sevenString + "7"
    }
  }

  if(findFlg) println(sevenString.size) else println(-1)
}
