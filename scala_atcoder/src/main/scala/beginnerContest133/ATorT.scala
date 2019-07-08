package beginnerContest133

// https://atcoder.jp/contests/abc133/tasks/abc133_a

object ATorT extends App {
  val read = scala.io.StdIn.readLine()
  val array =  read.split(" ").map(_.toInt).toVector
  val taxi = array(2)
  val train = array(0) * array(1)

  if(train >= taxi) {
    println(taxi)
  } else {
    println(train)
  }
}