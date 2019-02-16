package beginnerContest118

// https://atcoder.jp/contests/abc118/tasks/abc118_b

object BFoodsLovedbyEveryone extends App {
  var nm = scala.io.StdIn.readLine()
  val nmArray =  nm.split(" ").map(_.toInt)
  val n = nmArray(0)
  val m = nmArray(1)
  var seqKa = Seq.empty[Int]
  for(i<-1 to n) {
    val ka = scala.io.StdIn.readLine()
    val kaArray = ka.split(" ").map(_.toInt)
    if(i == 1){
      seqKa = kaArray.tail
    } else {
      seqKa = seqKa.filter(s => kaArray.tail.find(_ == s).isDefined)
    }
  }
  println(seqKa.length)
}
