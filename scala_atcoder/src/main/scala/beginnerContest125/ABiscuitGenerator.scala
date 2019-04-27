package beginnerContest125

// https://atcoder.jp/contests/abc125/tasks/abc125_a

object ABiscuitGenerator extends App {
  var read = scala.io.StdIn.readLine()
  val array =  read.split(" ").map(_.toInt).toVector
  var a = array(0)
  var b = array(1)
  var t = array(2)
  var count = 0
  var sec = 0
  while((a + sec) < (t + 0.5) ) {
    sec = a + sec
    count += b
  }
  print(count)
}
