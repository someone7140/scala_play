package beginnersSelection

// https://atcoder.jp/contests/abs/tasks/abc087_b

object Abc087bCoin extends App {
  var inputA = scala.io.StdIn.readInt()
  var inputB = scala.io.StdIn.readInt()
  var inputC = scala.io.StdIn.readInt()
  var inputX = scala.io.StdIn.readInt()
  var count = 0
  for ( a <- 0 to inputA; b <- 0 to inputB; c <- 0 to inputC ) {
    if ((a * 500 + b * 100 + c * 50) == inputX) {
    count += 1
    }
  
  }
  println(count)
}