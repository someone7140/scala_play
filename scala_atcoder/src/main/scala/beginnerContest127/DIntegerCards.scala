package beginnerContest127

// https://atcoder.jp/contests/abc127/tasks/abc127_d

object DIntegerCards extends App {
  val read = scala.io.StdIn.readLine()
  val array =  read.split(" ").map(_.toInt).toVector
  val n = array(0)
  val m = array(1)

  val readA = scala.io.StdIn.readLine()
  var arrayA =  readA.split(" ").map(_.toInt).toVector.sorted

  var bcArr = Vector.empty[(Int, Int)]
  for(i<-1 to m) {
    val readBC = scala.io.StdIn.readLine()
    val arrayBC =  readBC.split(" ").map(_.toInt).toVector
    bcArr :+= (arrayBC(0), arrayBC(1))
  }
  bcArr.foreach{ bc =>
    val count = bc._1
    val arrayTemp = arrayA.slice(count, arrayA.length)
    var addTemp = Vector.empty[Int]
    for(k<-0 to count - 1) {
      if (arrayA(k) < bc._2) {
        addTemp :+= bc._2
      } else{
        addTemp :+= arrayA(k)
      }
    }
    arrayA = (addTemp ++ arrayTemp).sorted
  }
  print(arrayA.sum)

}
