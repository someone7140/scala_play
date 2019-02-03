package beginnerContest117

// https://atcoder.jp/contests/abc117/tasks/abc117_b

object BPolygon extends App {
  var n = scala.io.StdIn.readInt()
  var s = scala.io.StdIn.readLine()
  val inputArray =  s.split(" ").map(_.toInt)
  val max = inputArray.max
  val sumExceptMax = inputArray.sum - max
  if (max < sumExceptMax) {
    println("Yes")
  } else {
    println("No")
  }
}
