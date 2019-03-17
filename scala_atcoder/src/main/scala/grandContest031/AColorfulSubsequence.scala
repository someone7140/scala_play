package grandContest031

// https://atcoder.jp/contests/agc031/tasks/agc031_a
import scala.collection.mutable

object AFavoriteSound extends App {
  var n = scala.io.StdIn.readInt()
  var s = scala.io.StdIn.readLine()
  var count:Long = n
  val divideVal:Long = 1000000007

  val map = mutable.Map[Char, Int]()
  s.foreach ( (char) => {
    val count = map.getOrElse( char, 0 )
    map.update( char, count+1 )
  })

  for (i <- 2 to n) {
    count += s.combinations(i).filter(v => v.length == v.distinct.length).map(v => v.map(c => map.get(c)).flatten.foldLeft(1)(_ * _)).sum
  }
  println(count % divideVal)
}
