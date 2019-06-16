package beginnerContest130

//https://atcoder.jp/contests/abc130/tasks/abc130_c

object CRectangleCutting extends App {
  val read = scala.io.StdIn.readLine()
  val array =  read.split(" ").map(_.toInt).toVector
  val result = array(0).toDouble * array(1).toDouble / 2d
  val several =
    if(array(0) == array(2) * 2 && array(1) == array(3) * 2) {
      1
    } else {
      0
    }
  println(result + " " + several)
}
