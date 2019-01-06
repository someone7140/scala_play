package beginnersSelection

// https://atcoder.jp/contests/abs/tasks/abc085_b

object Abc085bKagamiMochi extends App {
  var n = scala.io.StdIn.readInt()
  var dArray = Seq.empty[Int]
  for(i<-1 to n) {
    dArray :+=  scala.io.StdIn.readLine().toInt
  }
  println(dArray.distinct.length)
}