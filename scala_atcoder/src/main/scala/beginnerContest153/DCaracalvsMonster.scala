package beginnerContest153

// https://atcoder.jp/contests/abc153/tasks/abc153_d

object DCaracalvsMonster extends App {
  val h = scala.io.StdIn.readDouble()
  val log = (Math.log(h) / Math.log(2)).toInt
  var result = 0L
  (0 to log).foreach { i =>
    result = result + math.pow(2, i).toLong
  }
  println(result)

}
