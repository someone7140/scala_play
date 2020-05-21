package beginnerContest167

// https://atcoder.jp/contests/abc167/tasks/abc167_c

object CSkillUp extends App {
  val nmx =  scala.io.StdIn.readLine()
  val nmxArray =  nmx.split(" ").map(_.toInt).toSeq
  val n = nmxArray(0)
  val m = nmxArray(1)
  val x = nmxArray(2)

  var caVector = Vector.empty[Vector[Int]]
  (1 to n).foreach { _ =>
    val ca =  scala.io.StdIn.readLine()
    val caArray =  ca.split(" ").map(_.toInt).toVector
    caVector :+= caArray
  }

  var resultVector = Vector.empty[Int]
  (1 to n).foreach { i =>
    caVector.combinations(i).foreach { cas =>
      var rikaiSum = scala.collection.mutable.Seq.empty[Int]
      cas.foreach { ca =>
        if (rikaiSum.length == 0) {
          rikaiSum = scala.collection.mutable.ListBuffer(ca.tail: _*)
        } else {
          (0 to m - 1).foreach { i =>
            rikaiSum(i) = rikaiSum(i) + ca(i + 1)
          }
        }

      }
      if (!rikaiSum.exists(r => r < x)) {
        resultVector :+= cas.map(ca => ca.head).sum
      }
    }
  }
  if (resultVector.length == 0) {
    println(-1)
  } else {
    println(resultVector.min)
  }
}
