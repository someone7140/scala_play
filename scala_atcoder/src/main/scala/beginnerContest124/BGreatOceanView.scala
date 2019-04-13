package beginnerContest124

// https://atcoder.jp/contests/abc124/tasks/abc124_b

object BGreatOceanView extends App {
  val n = scala.io.StdIn.readInt()
  var read = scala.io.StdIn.readLine()
  val array =  read.split(" ").map(_.toInt).toVector
  var hArray = Vector.empty[Int]

  array.zipWithIndex.foreach{ case(h, index) =>
    if (index == 0) {
      hArray :+= h
    } else {
      if(h >= hArray.max) {
        hArray :+= h
      }
    }
  }
  print(hArray.length)
}
