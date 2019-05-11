package diverta2019ProgrammingContest

// https://atcoder.jp/contests/diverta2019/tasks/diverta2019_b

object BRGBBoxes extends App {
  var read = scala.io.StdIn.readLine()
  val array =  read.split(" ").map(_.toInt).toVector
  val r = array(0)
  val g = array(1)
  val b = array(2)
  val n = array(3)
  var count = 0
  val rd = n / r
  val gd = n / g
  val bd = n / b
  for{
    rc <- (0 to rd)
    gc <- (0 to gd)
    bc <- (0 to bd)
  }{
    val sum = r * rc + g * gc + b * bc
    if ( sum != 0 && n == sum) {
      count += 1
    }
  }
  println(count)
}
