package beginnersSelection

// https://atcoder.jp/contests/abs/tasks/abc086_a

object Abc086aProduct extends App {
  var s = scala.io.StdIn.readLine()
  val inputArray =  s.split(" ")
  def judgeEven(input: String) : Boolean = {
    if (input.last.toInt % 2 == 0) {
      true
    } else {
      false
    }
  }
  if(judgeEven(inputArray(0)) || judgeEven(inputArray(1))) {
    println("Even")
  } else {
    println("Odd")
  }
}