package beginnerContest133

// https://atcoder.jp/contests/abc133/tasks/abc133_b

object BGoodDistance extends App {
  val read = scala.io.StdIn.readLine()
  val arrayNd =  read.split(" ").map(_.toInt).toVector
  val n = arrayNd(0)
  val d = arrayNd(1)
  var xArray = Vector.empty[Vector[Int]]
  (1 to n).foreach { _ =>
    val readX = scala.io.StdIn.readLine()
    xArray :+= readX.split(" ").map(_.toInt).toVector
  }
  var count = 0
  for(i <- 0 to n - 2) {
    for(k <- (i+1) to n -1) {
      var sum = 0d
      for(j <- 0 to d - 1) {
        sum += Math.pow((xArray(i)(j) - xArray(k)(j)), 2)
      }
      val sqrtDouble = Math.sqrt(sum)
      if(sqrtDouble - sqrtDouble.toInt == 0) {
        count += 1
      }
    }
  }
  println(count)
}
