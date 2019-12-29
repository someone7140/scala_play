package beginnerContest147

// https://atcoder.jp/contests/abc147/tasks/abc147_c

import scala.util.control.Breaks

object CHonestOrUnkind2 extends App {
  val n = scala.io.StdIn.readInt()
  var xyVectorVector = Vector.empty[Vector[Vector[Int]]]
  (1 to n).foreach {_ =>
    val a = scala.io.StdIn.readInt()
    var xyVector = Vector.empty[Vector[Int]]
    (1 to a).foreach {_ =>
      val xyInput = scala.io.StdIn.readLine()
      val xy = xyInput.split(" ").map(_.toInt).toVector
      xyVector :+= xy
    }
    xyVectorVector :+= xyVector
  }

  def check(userList: Vector[Int]): Boolean = {
    var result = true
    val b = new Breaks
    b.breakable {
      userList.zipWithIndex.foreach { u =>
        if (u._1 == 1) {
          val xyVector = xyVectorVector(u._2)
          xyVector.foreach { xy =>
            if (userList(xy(0) - 1) != xy(1)) {
              result = false
              b.break()
            }
          }
        }
      }
    }
    result
  }
  val b1 = new Breaks
  var result = Vector.empty[Int]
  b1.breakable {
    (0 to n).foreach { fuseizitsuNum =>
      var userList = Vector.empty[Int]
      (0 to n - 1).foreach { _ =>
        if (userList.filter(_ == 0).size < fuseizitsuNum) {
          userList :+= 0
        } else {
          userList :+= 1
        }
      }
      val b2 = new Breaks

      b2.breakable {
        userList.permutations.foreach { u =>
          if (check(u)) {
            result = u
            b2.break()
          }
        }
      }
      if(result.nonEmpty) {
        b1.break()
      }
    }
  }
  println(result.filter(_ == 1).size)

}
