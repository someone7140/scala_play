package beginnerContest145

// https://atcoder.jp/contests/abc145/tasks/abc145_c

object CAverageLength extends App {
  val n =  scala.io.StdIn.readInt()
  var xy = Vector.empty[Seq[Int]]
  for(i<-1 to n) {
    val xyInput = scala.io.StdIn.readLine()
    xy :+= xyInput.split(" ").map(_.toInt).toSeq
  }
  val xyPattern = xy.permutations
  var sum = 0d
  xyPattern.foreach { xyList =>
    for(i<-1 to n - 1) {
      val beforeX = xyList(i - 1)(0)
      val beforeY = xyList(i - 1)(1)
      val afterX = xyList(i)(0)
      val afterY = xyList(i)(1)
      sum += math.sqrt(math.pow(beforeX - afterX, 2) + math.pow(beforeY - afterY, 2))
    }
  }
  println(sum / xy.permutations.length)
}

