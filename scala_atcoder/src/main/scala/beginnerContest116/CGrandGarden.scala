package beginnerContest116

// https://atcoder.jp/contests/abc116/tasks/abc116_c

object CGrandGarden extends App {
  var n = scala.io.StdIn.readInt()
  var s = scala.io.StdIn.readLine()
  var inputArray =  s.split(" ").map(_.toInt)
  var total = 0
  var active = 0

  for (i<-0 to n - 1) {
    if (active < inputArray(i)) {
      total += inputArray(i) - active
    }
    active = inputArray(i)
  }
  println(total)
}