package beginnerContest157

// https://atcoder.jp/contests/abc157/tasks/abc157_c

object CGuessTheNumber extends App {
  val nmInput  = scala.io.StdIn.readLine()
  val nmArray = nmInput.split(" ").map(_.toInt).toSeq
  val n = nmArray(0)
  val m = nmArray(1)

  var scArray = Vector.empty[(Int, Int)]
  (1 to m).foreach { _=>
    val scInput  = scala.io.StdIn.readLine()
    val scInputArray = scInput.split(" ").map(_.toInt)
    val scTuple = (scInputArray(0), scInputArray(1))
    if (scArray.find(sc => sc == scTuple).isEmpty) {
      scArray :+= scTuple
    }
  }
  scArray = scArray.sortBy(sc => sc._1)
  if(n == 1 && scArray.length == 1 && scArray.head._1 == 1 && scArray.head._2 == 0) {
    println(0)
  } else if (
    (scArray.length > 0 && scArray.head._1 == 1 && scArray.head._2 == 0) ||
    scArray.groupBy(sc => sc._1).map(sc => sc._2.size).find(sc => sc >= 2).isDefined
  ) {
    println(-1)
  } else if(scArray.length == 0) {
    if(n == 1) {
      println(0)
    } else {
      var result = ""
      (1 to n).foreach { i =>
        if(i == 1) {
          result = "1"
        } else {
          result = result + "0"
        }
      }
      println(result)
    }
  } else {
    var result = ""
    (1 to n).foreach { i =>
      val sc = scArray.find(sc => sc._1 == i)
      if (sc.isEmpty) {
        if(i == 1) {
          result = "1"
        } else {
          result = result + "0"
        }
      } else {
        result = result + sc.get._2.toString
      }
    }
    println(result)
  }

}
