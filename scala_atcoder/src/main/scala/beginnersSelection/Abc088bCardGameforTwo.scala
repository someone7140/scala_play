package beginnersSelection

// https://atcoder.jp/contests/abs/tasks/abc088_b

object Abc088bCardGameforTwo extends App {
  var n = scala.io.StdIn.readInt()
  var s = scala.io.StdIn.readLine()
  val inputArray =  s.split(" ")
  var diffSum = 0
  
  inputArray.map(_.toInt).sorted.reverse.zipWithIndex.foreach { case(a:Int, i:Int) =>
    if(i % 2 == 1 ) {
      diffSum -= a
    } else {
      diffSum += a
    }
  }

  println(diffSum)
}