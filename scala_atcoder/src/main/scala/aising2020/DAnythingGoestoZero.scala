package aising2020

// https://atcoder.jp/contests/aising2020/tasks/aising2020_d

object DAnythingGoestoZero extends App {
  val n = scala.io.StdIn.readInt()
  val x = scala.io.StdIn.readLine()
  val oneCountOriginal = x.filter(c => c.toString == "1").size

  (0 to x.length - 1).foreach { i =>
    val targetStr = x(i).toString
    var oneCount = oneCountOriginal
    val xReversed = if (targetStr == "1") {
      oneCount = oneCount - 1
      val charArray = x.toCharArray()
      charArray(i) = '0'
      charArray.mkString
    } else {
      oneCount = oneCount + 1
      val charArray = x.toCharArray()
      charArray(i) = '1';
      charArray.mkString
    }
    var result = 0
    var tempWaru = oneCount
    var tempWarareru = Integer.parseInt(xReversed, 2);
    while(tempWaru != 0) {
      tempWaru = tempWarareru % tempWaru
      result = result + 1
      if (tempWaru != 0) {
        tempWarareru = tempWaru
        val bin = Integer.toBinaryString(tempWaru)
        tempWaru =  bin.filter(c => c.toString == "1").size
      }
    }
    println(result)
  }

}
