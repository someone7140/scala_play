package beginnerContest234

object DPrefixKthMax extends App {
  val nkVector = scala.io.StdIn.readLine().split(" ").map(_.toInt).toVector
  val n = nkVector(0)
  val k = nkVector(1)

  val pArray = scala.io.StdIn.readLine().split(" ").map(_.toInt)

  if (k == n) {
    val sortedP = pArray.sorted
    println(sortedP(0))
  } else {
    implicit val orderP = Ordering[Int].reverse
    val pq = new collection.mutable.PriorityQueue()
    var results = new Array[Int](n - k + 1)
    pArray.zipWithIndex.foreach(p => {
      if (p._2 == k - 1) {
        pq.addOne(p._1)
        results(p._2 - (k - 1)) = pq.head
      } else if (p._2 > k - 1) {
        pq.addOne(p._1)
        pq.dequeue()
        results(p._2 - (k - 1)) = pq.head
      } else {
        pq.addOne(p._1)
      }
    })
    println(results.mkString(sep = System.lineSeparator()))
  }
}
