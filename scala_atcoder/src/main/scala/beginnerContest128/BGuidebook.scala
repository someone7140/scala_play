package beginnerContest128

// https://atcoder.jp/contests/abc128/tasks/abc128_b

object BGuidebook extends App {
  val n = scala.io.StdIn.readInt()
  var spArray = Vector.empty[(String, Int, Int)]
  for(i<-1 to n) {
    val readSP = scala.io.StdIn.readLine()
    val arraySP =  readSP.split(" ")
    spArray :+= (arraySP(0), arraySP(1).toInt, i)
  }
  val spArraySorted = spArray.sortWith { (sp1, sp2) =>
    if(sp1._1 == sp2._1) {
      sp1._2 > sp2._2
    } else {
      sp1._1.compareToIgnoreCase(sp2._1) < 0
    }
  }
  spArraySorted.foreach(sp =>
    println(sp._3)
  )
}
