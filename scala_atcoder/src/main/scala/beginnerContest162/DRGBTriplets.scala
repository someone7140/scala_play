package beginnerContest162

// https://atcoder.jp/contests/abc162/tasks/abc162_d

object DRGBTriplets extends App {

  val n =  scala.io.StdIn.readInt()
  val s =  scala.io.StdIn.readLine()

  var result = 0L
  var tempS = s

  (1 to n - 2).foreach { a =>
    val head = tempS.head
    tempS = tempS.tail
    var tempS2 = tempS
    (a + 1 to n - 1).foreach { b =>
      val head2 = tempS2.head
      tempS2 = tempS2.tail
      if (head != head2) {
        val tempS3 = tempS2
        var tempResult = tempS3.filter(t => t != head && t != head2).size
        val bMinusa = b - a
        if (bMinusa <= tempS3.length) {
          val bMinuscChar = tempS3.charAt(bMinusa - 1)
          if (bMinuscChar != head && bMinuscChar != head2) {
            tempResult = tempResult - 1
          }
        }
        result = result + tempResult.toLong
      }

    }
  }
  println(result)
}
