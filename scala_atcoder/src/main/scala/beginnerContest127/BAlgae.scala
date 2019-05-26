package beginnerContest127

// https://atcoder.jp/contests/abc127/tasks/abc127_b

object BAlgae extends App {
  val read = scala.io.StdIn.readLine()
  val array =  read.split(" ").map(_.toLong).toVector
  val r = array(0)
  val D = array(1)
  val x2000 = array(2)
  var x = x2000

  for(i<-1 to 10) {
    x = r * x - D
    println(x)
  }

}
