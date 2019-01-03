package beginnersSelection

// https://atcoder.jp/contests/abs/tasks/abc083_b

object Abc083bSomeSums extends App {
  var s = scala.io.StdIn.readLine()
  val inputArray =  s.split(" ")
  
  val n = inputArray(0).toInt
  val a = inputArray(1).toInt
  val b = inputArray(2).toInt
  var resultArray = Seq.empty[Int]
  def judgeCount(iterator: Iterator[Char]): Boolean = {
    val c = iterator.map(_.asDigit).sum
    if(a <= c && c <= b) {
      true
    } else {
      false
    }
  }
  
  for(i <- 0 to n) {
    if (judgeCount(i.toString.iterator)) {
      resultArray :+= i
    }
  }
  
  println(resultArray.sum)
}