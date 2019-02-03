package beginnerContest117

// https://atcoder.jp/contests/abc117/tasks/abc117_c

object CStreamline extends App {
  var nm = scala.io.StdIn.readLine()
  var nm1 = nm.split(" ")
  val n = nm1(0).toInt
  val m = nm1(1).toInt
  var x = scala.io.StdIn.readLine()
  val xArray =  x.split(" ").toVector.map(_.toInt).sortBy(i => i)
  var dArray = Vector.empty[(Int,Int)]
  if(xArray.length > 1) {
    for (i <- 0 to (m - 2)) {
      val diff = (xArray(i + 1) - xArray(i)).abs
      dArray = (i + 1, diff) +: dArray
    }
    dArray = dArray.sortBy(_._2).reverse
    var sum = 0
    dArray.zipWithIndex.foreach{v =>
      if(v._2 > (n -2)) {
        sum += v._1._2
      }
    }
    println(sum)
  } else {
    println(0)
  }
}
