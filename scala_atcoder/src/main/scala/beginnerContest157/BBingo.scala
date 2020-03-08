package beginnerContest157

// https://atcoder.jp/contests/abc157/tasks/abc157_b

object BBingo extends App {
  val A1Input  = scala.io.StdIn.readLine()
  val A1Array = A1Input.split(" ").map(_.toInt).toSeq
  val A2Input  = scala.io.StdIn.readLine()
  val A2Array = A2Input.split(" ").map(_.toInt).toSeq
  val A3Input  = scala.io.StdIn.readLine()
  val A3Array = A3Input.split(" ").map(_.toInt).toSeq

  val n = scala.io.StdIn.readInt()
  var bFindArray = Vector.empty[(Int, Int)]

  (1 to n).foreach { _=>
    val b = scala.io.StdIn.readInt()
    if (A1Array.indexOf(b) != -1) {
      bFindArray :+= (1, A1Array.indexOf(b) + 1)
    }
    if (A2Array.indexOf(b) != -1) {
      bFindArray :+= (2, A2Array.indexOf(b) + 1)
    }
    if (A3Array.indexOf(b) != -1) {
      bFindArray :+= (3, A3Array.indexOf(b) + 1)
    }
  }

  if(
    bFindArray.groupBy(b => b._1).map(b => (b._1, b._2.size)).find(b => b._2 >= 3).isDefined ||
      bFindArray.groupBy(b => b._2).map(b => (b._1, b._2.size)).find(b => b._2 >= 3).isDefined ||
      (bFindArray.find(b => b == (1, 1)).isDefined && bFindArray.find(b => b == (2, 2)).isDefined && bFindArray.find(b => b == (3, 3)).isDefined) ||
      (bFindArray.find(b => b == (1, 3)).isDefined && bFindArray.find(b => b == (2, 2)).isDefined && bFindArray.find(b => b == (3, 1)).isDefined)
  ) {
    println("Yes")
  } else {
    println("No")
  }
}
