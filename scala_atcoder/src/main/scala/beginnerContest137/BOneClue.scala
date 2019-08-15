package beginnerContest137

// https://atcoder.jp/contests/abc137/tasks/abc137_b

object BOneClue extends App {
  val read = scala.io.StdIn.readLine()
  val array =  read.split(" ").map(_.toInt).toVector
  val x = array(1)
  var resultArray = Vector(x)
  val addCount = array(0) - 1
  for(i<-1 to addCount) {
    resultArray :+= (x - i)
    resultArray :+= (x + i)
  }
  println(resultArray.sorted.mkString(" "))
}
