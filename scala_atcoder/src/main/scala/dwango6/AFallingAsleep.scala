package dwango6

// https://atcoder.jp/contests/dwacon6th-prelims/tasks/dwacon6th_prelims_a

object AFallingAsleep extends App {
  val n = scala.io.StdIn.readInt()
  var playList = Vector.empty[(String, Int)]
  (1 to n).foreach { _ =>
    val stInput = scala.io.StdIn.readLine()
    val stInputArray = stInput.split(" ")
    val title = stInputArray(0)
    val time = stInputArray(1).toInt
    playList :+= (title, time)
  }
  val sleepTitle = scala.io.StdIn.readLine()
  var sleepTitleFind = false
  var sleepTime = 0
  playList.foreach { p =>
    if (sleepTitleFind) {
      sleepTime = sleepTime + p._2
    } else {
      if (p._1 == sleepTitle) {
        sleepTitleFind = true
      }
    }
  }
  println(sleepTime)
}
