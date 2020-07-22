package aising2020

import scala.util.control.Breaks

// https://atcoder.jp/contests/aising2020/tasks/aising2020_c

object CXYZTriplets extends App {
  val n = scala.io.StdIn.readInt()
  var fMap = scala.collection.mutable.Map.empty[Int, Set[Vector[Int]]]

  def caluc(x: Int, y: Int, z: Int) = {
    x * x + y * y + z * z + x * y + y * z + x * z
  }

  def loopVariableZ(x: Int, y: Int, z: Int) = {
    val b = new Breaks
    var i = z
    b.breakable {
      while (true) {
        val calucRes = caluc(x, y, i)
        if (calucRes > n) {
          b.break()
        } else {
          val fMapOpt = fMap.get(calucRes)
          if (fMapOpt.isDefined) {
            fMap.put(calucRes, fMapOpt.get + Vector(x, y, i).sorted)
          } else {
            fMap.put(calucRes, Set(Vector(x, y, i).sorted))
          }
        }
        i = i + 1
      }
    }
  }

  def loopVariableY(x: Int, y: Int, z: Int) = {
    val b = new Breaks
    var i = y
    b.breakable {
      while (true) {
        val calucRes = caluc(x, i, z)
        if (calucRes > n) {
          b.break()
        } else {
          val fMapOpt = fMap.get(calucRes)
          if (fMapOpt.isDefined) {
            fMap.put(calucRes, fMapOpt.get + Vector(x, i, z).sorted)
          } else {
            fMap.put(calucRes, Set(Vector(x, i, z).sorted))
          }
        }
        i = i + 1
        loopVariableZ(x, i, z)
      }
    }
  }

  def loopVariableX(x: Int, y: Int, z: Int) = {
    val b = new Breaks
    var i = x
    b.breakable {
      while (true) {
        val calucRes = caluc(i, y, z)
        if (calucRes > n) {
          b.break()
        } else {
          val fMapOpt = fMap.get(calucRes)
          if (fMapOpt.isDefined) {
            fMap.put(calucRes, fMapOpt.get + Vector(i, y, z).sorted)
          } else {
            fMap.put(calucRes, Set(Vector(i, y, z).sorted))
          }
        }
        i = i + 1
        loopVariableY(i, y, z)
      }

    }
  }

  loopVariableX(1, 1, 1)
  (1 to n).foreach { i =>
    val combVecOpt = fMap.get(i)
    if (combVecOpt.isDefined) {
      var result = 0
      val combVecVec = combVecOpt.get
      combVecVec.foreach { combVec =>
        if (combVec(0) == combVec(1) && combVec(0) == combVec(2) && combVec(1) == combVec(2)) {
          result = result + 1
        } else if (combVec(0) != combVec(1) && combVec(0) != combVec(2) && combVec(1) != combVec(2)) {
          result = result + 6
        } else {
          result = result + 3
        }
      }
      println(result)
    } else {
      println(0)
    }
  }
}
