package beginnerContest138

// https://atcoder.jp/contests/abc138/tasks/abc138_c

object CAlchemist extends App {
  val n = scala.io.StdIn.readInt()
  val readV =  scala.io.StdIn.readLine()
  val vArray = readV.split(" ").map(_.toDouble).toVector.sorted
  var result = 0d
  var before = 0d

  vArray.zipWithIndex.foreach(v =>
    if(v._2 == 0) {
      result = v._1
    } else {
      result = (result + v._1) / 2d
    }
  )
  println(result)
}
