package beginnerContest117

// https://atcoder.jp/contests/abc117/tasks/abc117_a

object AEntranceExamination extends App {
  var s = scala.io.StdIn.readLine()
  val inputArray =  s.split(" ")
  val result:Double = inputArray(0).toDouble / inputArray(1).toDouble
  println(result)
}
