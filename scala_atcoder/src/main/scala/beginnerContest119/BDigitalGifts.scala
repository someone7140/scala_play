package beginnerContest119

// https://atcoder.jp/contests/abc119/tasks/abc119_b

object BDigitalGifts extends App {
  var total:Double = 0
  var n = scala.io.StdIn.readInt()
  for(i<-1 to n) {
    val xu = scala.io.StdIn.readLine()
    val xuArray = xu.split(" ")
    if(xuArray(1) == "JPY"){
      total += xuArray(0).toDouble
    } else {
      total += xuArray(0).toDouble * 380000
    }
  }
  println(total)
}
