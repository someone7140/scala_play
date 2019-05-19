package beginnerContest126

// https://atcoder.jp/contests/abc126/tasks/abc126_c

object CDiceandCoin extends App {
  val read = scala.io.StdIn.readLine()
  val array = read.split(" ").map(_.toInt).toVector
  val n = array(0)
  val k = array(1)
  var vec = Vector.empty[Double]

  for (i<-1 to n) {
    if (i < k) {
      var count = 0
      var temp = i
      while(temp < k) {
        count = count + 1
        temp = temp * 2
      }
      vec :+= (1d / n.toDouble) * Math.pow(0.5, count)
    } else {
      vec :+= (1d / n.toDouble)
    }
  }
  print(vec.sum)
}
