package beginnerContest120

// https://atcoder.jp/contests/abc120/tasks/abc120_c

object CUnification extends App {
  var input = scala.io.StdIn.readLine()
  var count = 0
  def excludeZeroOne(s: String): Unit = {
    val lastIndex = s.lastIndexOf("01")
    if(lastIndex == -1) {
      print(count)
    } else {
      count += 2
      val size = s.size
      var i = 0
      if(size < 4) {
        print(count)
      } else {
        i = lastIndex
        // println(s.substring(0, i) + s.substring(i + 2, size))
        excludeZeroOne(s.substring(0, i) + s.substring(i + 2, size))
      }
    }
  }
  excludeZeroOne(input)

}
