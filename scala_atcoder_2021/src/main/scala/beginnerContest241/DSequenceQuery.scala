package beginnerContest241

import scala.math.Ordering

object DSequenceQuery extends App {
  val q = scala.io.StdIn.readInt()

  var resultList = Vector.empty[Long]

  implicit val reverseOrderP = Ordering[Long].reverse
  val reversePq = new collection.mutable.PriorityQueue()

  (1 to q).foreach(_ => {
    val qInput = scala.io.StdIn.readLine().split(" ").toVector
    if (qInput(0) == "1") {
      val addQ = qInput(1).toLong
      reversePq.addOne(addQ)
    } else if (qInput(0) == "2") {
      val x = qInput(1).toLong
      val index = qInput(2).toInt
      val filtered = reversePq.filter(p => p <= x)
      if (filtered.size >= index) {
        resultList :+= filtered.toVector(index - 1)
      } else {
        resultList :+= -1
      }
    } else {
      val x = qInput(1).toLong
      val index = qInput(2).toInt
      val filtered = reversePq.filter(p => p >= x)
      if (filtered.size >= index) {
        resultList :+= filtered.toVector(index - 1)
      } else {
        resultList :+= -1
      }
    }
  })

  println(resultList.mkString(System.lineSeparator))
}
