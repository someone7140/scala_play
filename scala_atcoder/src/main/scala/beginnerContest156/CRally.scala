package beginnerContest156

// https://atcoder.jp/contests/abc156/tasks/abc156_c

object CRally extends App {
  val n = scala.io.StdIn.readInt()
  val xInput =  scala.io.StdIn.readLine()
  val xArray = xInput.split(" ").map(_.toInt).toVector

  val min = xArray.min
  val max = xArray.max

  var result = -1

  (min to max).foreach { i =>
    val tempSum = xArray.map(x => (x - i) * (x - i)).sum
    if(result < 0 || tempSum < result) {
      result = tempSum
    }
  }
  println(result)
}
