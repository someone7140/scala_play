package beginnerContest175

// https://atcoder.jp/contests/abc175/tasks/abc175_c

object CWalkingTakahashi extends App {
  val xkdInput = scala.io.StdIn.readLine()
  val xkdArray = xkdInput.split(" ").map(_.toLong).toVector

  val x = xkdArray(0)
  val k = xkdArray(1)
  val d = xkdArray(2)

  var tempK = k
  var tempMin = x

  if (tempMin < 0) {
    var kMinus = (Math.abs(x) / d)
    if (kMinus > k) {
      kMinus = k
      tempK = 0
      tempMin = x + kMinus * d
    } else {
      tempK = kMinus
      tempMin = x + kMinus * d
      val tempMin2 = x + d
      if(Math.abs(tempMin) > Math.abs(tempMin2)) {
        tempMin = tempMin2
        tempK = tempK - 1
      }
    }
  } else if(tempMin > 0) {
    var kMinus = (Math.abs(x) / d)
    if (kMinus > k) {
      kMinus = k
      tempK = 0
      tempMin = x - kMinus * d
    } else {
      tempK = kMinus
      tempMin = x - kMinus * d
      val tempMin2 = x - d
      if(Math.abs(tempMin) > Math.abs(tempMin2)) {
        tempMin = tempMin2
        tempK = tempK - 1
      }
    }
  }

  if(tempK == 0) {
    println(Math.abs(tempMin))
  } else if (tempK % 2 == 0) {
    println(Math.abs(tempMin))
  } else {
    if (tempMin < 0) {
      println(Math.abs(tempMin + d))
    } else {
      println(Math.abs(tempMin - d))
    }
  }
}
