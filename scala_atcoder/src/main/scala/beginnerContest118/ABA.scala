package beginnerContest118

// https://atcoder.jp/contests/abc118/tasks/abc118_a

object ABA extends App {
  var s = scala.io.StdIn.readLine()
  val inputArray =  s.split(" ").map(_.toInt)
  if(inputArray(1) % inputArray(0) == 0) {
    println(inputArray(0) + inputArray(1))
  } else {
    println(inputArray(1)- inputArray(0))
  }
}
