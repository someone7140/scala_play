package beginnersSelection

// https://atcoder.jp/contests/abs/tasks/arc089_a

object Abc086cTraveling extends App {
  var n = scala.io.StdIn.readInt()
  var t = 0
  var x = 0
  var y = 0

  def judgePossible(inputArray: Seq[Int]): Boolean = {
    if (inputArray(1) != x) {
      t += (inputArray(1) - x).abs
      x = inputArray(1)
    }
    if (inputArray(2) != y) {
      t += (inputArray(2) - y).abs
      y = inputArray(2)
    }
    if (inputArray(0) == t) {
      true
    } else if (inputArray(0) > t && (inputArray(0) - t) % 2 == 0) {
      true
    } else {
      false
    }
  }

  var judgeFlg = true
  for(i<-1 to n) {
    val t = scala.io.StdIn.readLine()
    if(judgeFlg && !judgePossible(t.split(" ").map(_.toInt))) {
      judgeFlg = false
    }
  }
  if(judgeFlg) {
    println("Yes")
  } else {
    println("No")
  }
}
