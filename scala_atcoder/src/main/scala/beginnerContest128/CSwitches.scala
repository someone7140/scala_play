package beginnerContest128

// https://atcoder.jp/contests/abc128/tasks/abc128_c

object CSwitches extends App {
  val read = scala.io.StdIn.readLine()
  val array =  read.split(" ").map(_.toInt).toVector
  val n = array(0)
  val m = array(1)
  var sArr = Vector.empty[Vector[Int]]
  for(i<-1 to m) {
    val readKS = scala.io.StdIn.readLine()
    val arrayS =  readKS.split(" ").map(_.toInt).toVector.tail
    sArr :+= arrayS
  }
  val readP = scala.io.StdIn.readLine()
  val arrayP =  readP.split(" ").map(_.toInt).toVector

  var resultMapArr = Vector.empty[Map[Int, String]]
  sArr.zipWithIndex.foreach { case (s, i) =>
    if (i == 0) {
      if (arrayP(i) == 0) {
        s.combinations(2).foreach { c =>
          var tempMap = Map.empty[Int, String]


          resultMapArr :+= tempMap
        }
        resultMapArr :+= Map.empty[Int, String]
      } else {

      }

    } else {

    }

  }
  b.breakable{
    lrArr.zipWithIndex.foreach { case (lr, i) =>
      if(i == 0) {
        result = lr
      } else {
        var min = 0
        var max = 0
        if (result._1 >= lr._1) {
          min = result._1
        } else {
          min = lr._1
        }
        if (result._2 >= lr._2) {
          max = lr._2
        } else {
          max = result._2
        }
        if(min > max) {
          result = (0, 0)
          b.break()
        } else {
          result = (min, max)
        }
      }
    }
  }
  if (result._1 == 0 && result._2 == 0) {
    print(0)
  } else {
    print(result._2 - result._1 + 1)
  }

}
