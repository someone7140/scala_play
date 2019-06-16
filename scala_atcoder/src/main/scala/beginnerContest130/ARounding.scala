package beginnerContest130

//https://atcoder.jp/contests/abc130/tasks/abc130_a

object ARounding extends App {
  val read = scala.io.StdIn.readLine()
  val array =  read.split(" ").map(_.toInt).toVector
  println(
    if(array(0) < array(1)){
      0
    } else {
      10
    })
}
