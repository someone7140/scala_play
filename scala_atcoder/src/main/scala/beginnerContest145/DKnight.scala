package beginnerContest145

// https://atcoder.jp/contests/abc145/tasks/abc145_d

object DKnight extends App {
  val xyInput = scala.io.StdIn.readLine()
  val xy = xyInput.split(" ").map(_.toInt).toSeq
  val x = xy(0)
  val y = xy(1)
  val xyDiff = x - y
  var xLargeCount = 0
  var yLargeCount = 0
  if (xyDiff == 0) {
    if (xLargeCount % 3 == 0) {
      xLargeCount = x / 3
      yLargeCount = xLargeCount
    } else {
      xLargeCount = 0
      yLargeCount = 0
    }
  } else if (xyDiff > 0) {
    if ((x + xyDiff) % 3 == 0) {
      xLargeCount = (x + xyDiff) / 3
      if ((y - xLargeCount) % 2 == 0) {
        yLargeCount = (y - xLargeCount) / 2
      } else {
        xLargeCount = 0
        yLargeCount = 0
      }
    } else {
      xLargeCount = 0
      yLargeCount = 0
    }
  } else {
    if ((y - xyDiff) % 3 == 0) {
      yLargeCount = (y - xyDiff) / 3
      if ((x - yLargeCount) % 2 == 0) {
        xLargeCount = (x - yLargeCount) / 2
      } else {
        xLargeCount = 0
        yLargeCount = 0
      }
    }
  }
  implicit class RichInt(val n : Int) {
    def ! : Long = (1L to n.toLong).product
  }
  if(xLargeCount == 0 && yLargeCount == 0) {
    println(0)
  } else {
    println((xLargeCount + yLargeCount).! / (xLargeCount.! * yLargeCount.!) % 1000000007L)
  }
}
