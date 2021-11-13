package keyence2021

object ALastCard extends App {
  val nkaVector = scala.io.StdIn.readLine().split(" ").map(_.toInt).toVector
  val n = nkaVector(0)
  val k = nkaVector(1)
  val a = nkaVector(2)

  var temp = a
  var count = 1
  while (count < k) {
    if (temp != n) {
      temp = temp + 1
    } else {
      temp = 1
    }
    count = count + 1
  }
  println(temp)
}
