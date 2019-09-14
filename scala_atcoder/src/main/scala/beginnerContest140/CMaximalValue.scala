package beginnerContest140

// https://atcoder.jp/contests/abc140/tasks/abc140_c

object CMaximalValue extends App {
  val n = scala.io.StdIn.readInt()
  val readB =  scala.io.StdIn.readLine()
  val bArray = readB.split(" ").map(_.toInt).toVector

  var resultVec = Vector.empty[Int]
  val size = bArray.size
  (0 to (n - 1)).foreach { i =>
    if (i == 0) {
      resultVec :+= bArray(0)
    } else if (i == (n - 1)) {
      resultVec :+= bArray(n - 2)
    } else {
      val value = bArray(i)
      val before = bArray(i - 1)
      resultVec :+= (if (value > before) before else value)
    }
  }
  println(resultVec.sum)
}
