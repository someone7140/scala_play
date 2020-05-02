package beginnerContest165

// https://atcoder.jp/contests/abc165/tasks/abc165_c

import scala.util.control.Breaks

object CManyRequirements extends App {
  val nmq =  scala.io.StdIn.readLine()
  val nmqArray = nmq.split(" ").map(_.toInt).toSeq
  val n = nmqArray(0)
  val m = nmqArray(1)
  val q = nmqArray(2)

  var abcdVector = Vector.empty[Vector[Int]]
  (1 to q).foreach { _ =>
    val a =  scala.io.StdIn.readLine()
    abcdVector :+= a.split(" ").map(_.toInt).toVector
  }
  val max = abcdVector.map(a => a(3)).sum
  var tempMax = 0

  def getInitialAArray(): scala.collection.mutable.Seq[Int] = {
    var returnSeq = scala.collection.mutable.Seq.empty[Int]
    (1 to n).foreach { _=>
      returnSeq :+= 1
    }
    returnSeq
  }
  var aSeq = getInitialAArray()

  val break = new Breaks
  break.breakable {
    (0 to n - 1).foreach { i =>
      kensyou(i)
    }

    def kensyou(index: Int): Unit = {
      if(index == 0) {
        (1 to m).foreach { i =>
          aSeq(n - 1) = i
          calc(aSeq)
        }
      } else {
        (1 to m).foreach { i =>
          aSeq(n - 1 - index) = i
          kensyou(index - 1)
        }
      }
    }

    def calc(kensyouArray: scala.collection.mutable.Seq[Int]) = {
      var tempCalc = 0
      abcdVector.foreach { abcd =>
        if (kensyouArray(abcd(1) - 1) - kensyouArray(abcd(0) - 1) == abcd(2)) {
          tempCalc = tempCalc + abcd(3)
        }
      }

      if(tempCalc == max) {
        tempMax = tempCalc
        break.break()
      } else if(tempCalc > tempMax) {
        tempMax = tempCalc
      }
    }
  }

  println(tempMax)
}
