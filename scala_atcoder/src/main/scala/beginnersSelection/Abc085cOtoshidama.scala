package beginnersSelection

// https://atcoder.jp/contests/abs/tasks/abc085_c

object Abc085cOtoshidama extends App {
  var s = scala.io.StdIn.readLine()
  val inputArray =  s.split(" ")
  val n = inputArray(0).toInt
  var y = inputArray(1).toInt
  var a = 0
  var b = 0
  var c = 0
  for ( i <- 1 to n ) {
    if (5000 * (n - i + 1) > y) {
      y -= 1000
      c += 1
    } else if (5000 * (n - i + 1) < y) {
      y -= 10000
      a += 1
    } else {
      y -= 5000
      b += 1
    }
  }
  if (y != 0) {
    a = -1
    b = -1
    c = -1
  }
  println(a + " " + b + " " + c)
}