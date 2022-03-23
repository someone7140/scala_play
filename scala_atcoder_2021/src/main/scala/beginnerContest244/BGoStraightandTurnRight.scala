package beginnerContest244

object BGoStraightandTurnRight extends App {
  val n = scala.io.StdIn.readInt()
  val t = scala.io.StdIn.readLine()
  var x = 0
  var y = 0
  var direction = "xPlus"

  def changeDirection(): Unit = {
    if (direction == "xPlus") {
      direction = "yMinus"
    } else if (direction == "xMinus") {
      direction = "yPlus"
    } else if (direction == "yPlus") {
      direction = "xPlus"
    } else if (direction == "yMinus") {
      direction = "xMinus"
    }
  }

  t.toCharArray.foreach(tChar => {
    val tStr = tChar.toString
    if (tStr == "S") {
      if (direction == "xPlus") {
        x = x + 1
      } else if (direction == "xMinus") {
        x = x - 1
      } else if (direction == "yPlus") {
        y = y + 1
      } else if (direction == "yMinus") {
        y = y - 1
      }
    } else {
      changeDirection()
    }
  })

  println(x + " " + y)
}
