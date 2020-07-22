package beginnerContest172

// https://atcoder.jp/contests/abc172/tasks/abc172_c

object CTsundoku extends App {
  val nmk = scala.io.StdIn.readLine()
  val nmkArray = nmk.split(" ").map(_.toLong).toSeq
  val k = nmkArray(2)

  val a = scala.io.StdIn.readLine()
  val aArray = a.split(" ").map(_.toLong).toVector

  val b = scala.io.StdIn.readLine()
  val bArray = b.split(" ").map(_.toLong).toVector

  var resultVec = Vector.empty[Int]

  def calculate(aArrayInput: Vector[Long], bArrayInput: Vector[Long], timeCount: Long, resultTemp :Int): Unit = {
    if (aArrayInput.isEmpty && bArrayInput.isEmpty) {
      resultVec :+= resultTemp
    } else {
      if (timeCount > k) {
        resultVec :+= resultTemp
      } else {
        if (aArrayInput.isEmpty) {
          val newTimeCount = timeCount + bArrayInput.head
          val nextResult = if (newTimeCount > k) resultTemp else resultTemp + 1
          calculate(aArrayInput, bArrayInput.tail, newTimeCount, nextResult)
        } else if (bArrayInput.isEmpty) {
          val newTimeCount = timeCount + aArrayInput.head
          val nextResult = if (newTimeCount > k) resultTemp else resultTemp + 1
          calculate(aArrayInput.tail, bArrayInput, newTimeCount, nextResult)
        } else {
          val newTimeCountA = timeCount + aArrayInput.head
          val nextResultA = if (newTimeCountA > k) resultTemp else resultTemp + 1
          calculate(aArrayInput.tail, bArrayInput, newTimeCountA, nextResultA)

          val newTimeCountB = timeCount + bArrayInput.head
          val nextResultB = if (newTimeCountB > k) resultTemp else resultTemp + 1
          calculate(aArrayInput, bArrayInput.tail, newTimeCountB, nextResultB)
        }
      }
    }
  }

  calculate(aArray, bArray, 0L, 0)

  println(resultVec.max)
}
