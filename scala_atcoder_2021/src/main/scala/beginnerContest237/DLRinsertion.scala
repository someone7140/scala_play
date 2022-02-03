package beginnerContest237

object DLRinsertion extends App {
  val n = scala.io.StdIn.readInt()
  val s = scala.io.StdIn.readLine()
  var sArray = s.toCharArray.map(c => c.toString)

  val qBefore = new java.util.ArrayDeque[Int]
  val qMiddle = new java.util.ArrayDeque[Int]
  val qAfter = new java.util.ArrayDeque[Int]

  qMiddle.addLast(0)
  sArray.zipWithIndex.foreach(si => {
    if (si._1 == "L") {
      qMiddle.addFirst(si._2 + 1)
      val after = qMiddle.removeLast()
      qAfter.addFirst(after)
    } else {
      qMiddle.addLast(si._2 + 1)
      val before = qMiddle.removeFirst()
      qBefore.addLast(before)
    }
  })

  val before = if (qBefore.size() > 0) qBefore.toArray().mkString(" ") + " " else ""
  val middle =  qMiddle.toArray().mkString(" ")
  val after =  if (qAfter.size() > 0) " " + qAfter.toArray().mkString(" ") else ""
  println(before + middle + after)
}
