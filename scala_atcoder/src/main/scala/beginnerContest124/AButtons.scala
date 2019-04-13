package beginnerContest124

// https://atcoder.jp/contests/abc124/tasks/abc124_a

object AButtons extends App {
  var read = scala.io.StdIn.readLine()
  val array =  read.split(" ").map(_.toInt).toVector
  var a = array(0)
  var b = array(1)
  var sum = 0
  def getCoin() = {
    if(a >= b) {
      sum += a
      a = a - 1
    } else {
      sum += b
      b = b - 1
    }
  }
  getCoin()
  getCoin()
  println(sum)

}
