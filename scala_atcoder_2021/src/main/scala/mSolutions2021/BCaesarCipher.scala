package mSolutions2021

object BCaesarCipher extends App {
  val s = scala.io.StdIn.readLine()
  val t = scala.io.StdIn.readLine()

  def getSabunSeq(word: String): Seq[Integer] = {
    val charArray = word.toCharArray
    (0 to charArray.size - 2).map(i => {
      val beforeInt = word(i).toInt
      val afterInt = word(i + 1).toInt
      val sabun = afterInt - beforeInt
      if (sabun >= 0) {
        afterInt - beforeInt
      } else {
        afterInt - beforeInt + 26
      }
    })
  }
  if (s.length == 1) {
    println("Yes")
  } else {
    val sResult = getSabunSeq(s)
    val tResult = getSabunSeq(t)
    if (sResult == tResult) {
      println("Yes")
    } else {
      println("No")
    }
  }
}
