package beginnerContest139

// https://atcoder.jp/contests/abc139/tasks/abc139_b

object BPowerSocket extends App {
  val input =  scala.io.StdIn.readLine()
  val AB = input.split(" ").map(_.toInt).toVector
  val a = AB(0)
  val b = AB(1)
  var tapCount = 0
  var plugCount = 1

  while(plugCount < b) {
    plugCount = plugCount - 1 + a
    tapCount += 1
  }
  println(tapCount)
}
