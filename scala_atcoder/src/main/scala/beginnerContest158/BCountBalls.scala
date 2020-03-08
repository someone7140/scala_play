package beginnerContest158

// https://atcoder.jp/contests/abc158/tasks/abc158_b

object BCountBalls extends App {
  val nabInput  = scala.io.StdIn.readLine()
  val nabArray = nabInput.split(" ").map(_.toLong).toSeq
  val n = nabArray(0)
  val a = nabArray(1)
  val b = nabArray(2)
  val aplusb = a + b

  val syou = n / aplusb
  val amari = n % aplusb

  println(
    syou * a + (if (amari > a) a else amari)
  )
}
