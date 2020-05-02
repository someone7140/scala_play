package beginnerContest165

// https://atcoder.jp/contests/abc165/tasks/abc165_b

object B1Percent extends App {
  val x =  scala.io.StdIn.readLong()
  var loopFlg = true
  var count = 0
  var temp = 100L

  while(loopFlg) {
    temp = (temp * 1.01d).toLong
    count = count + 1
    if(temp >= x) {
      loopFlg = false
    }
  }
  println(count)
}
