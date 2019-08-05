package beginnerContest136

// https://atcoder.jp/contests/abc136/tasks/abc136_a

object ATransfer extends App {
  val read = scala.io.StdIn.readLine()
  val array =  read.split(" ").map(_.toInt).toVector
  val enable = array(0) - array(1)
  if (array(2) - enable < 0) {
    println(0)
  } else {
    println(array(2) - enable)
  }
}
