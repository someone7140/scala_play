package beginnerContest243

object DMovesonBinaryTree extends App {
  val nxVec = scala.io.StdIn.readLine().split(" ").map(_.toLong)
  val n = nxVec(0)
  val x = nxVec(1)
  var result = BigInt(x)

  val sList = scala.io.StdIn.readLine()
  var deque =  new java.util.ArrayDeque[String]
  sList.toCharArray.zipWithIndex.foreach(s => {
    val sString = s._1.toString
    if (s._2 == 0) {
      deque.addLast(sString)
    } else {
      val last = deque.peekLast()
      if (sString == "U") {
        if (last == "L" || last == "R") {
          deque.removeLast()
        } else {
          deque.addLast(sString)
        }
      } else {
        deque.addLast(sString)
      }
    }
  })

  deque.toArray().foreach(s => {
    if (s == "U") {
      result = result / 2
    } else if (s == "L") {
      result = result * 2
    } else {
      result = result * 2 + 1
    }
  })

  println(result)
}
