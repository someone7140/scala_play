package mSolutions2021

import scala.util.control.Breaks

object CGraphIsomorphism extends App {
  val nmVector = scala.io.StdIn.readLine().split(" ").map(_.toInt).toVector
  val n = nmVector(0)
  val m = nmVector(1)

  if (m == 0) {
    println("Yes")
  } else {
    val takahashiArray = Array.fill(n)(Vector.empty[Int])
    (0 to m - 1).foreach(_ => {
      val abVector = scala.io.StdIn.readLine().split(" ").map(_.toInt).toVector
      val a = abVector(0) - 1
      val b = abVector(1) - 1
      takahashiArray(a) = takahashiArray(a).appended(b).sorted
      takahashiArray(b) = takahashiArray(b).appended(a).sorted
    })

    var aokiMap = scala.collection.mutable.Map[Int, Vector[Int]]()
    (0 to m - 1).foreach(_ => {
      val cdVector = scala.io.StdIn.readLine().split(" ").map(_.toInt).toVector
      val c = cdVector(0) - 1
      val d = cdVector(1) - 1

      val cOpt = aokiMap.get(c)
      if (cOpt.isEmpty) {
        aokiMap += c -> Vector(d)
      } else {
        val cVec = cOpt.get
        aokiMap += c -> cVec.appended(d).sorted
      }

      val dOpt = aokiMap.get(d)
      if (dOpt.isEmpty) {
        aokiMap += d -> Vector(c)
      } else {
        val dVec = dOpt.get
        aokiMap += d -> dVec.appended(c).sorted
      }
    })

    var result = false

    val b1 = new Breaks

    b1.breakable {
      (0 to n - 1).permutations.foreach(iSeq => {
        val b2 = new Breaks
        b2.breakable {
          (0 to n - 1).foreach(j => {
            val takahashiVec = takahashiArray(j)
            val indexAoki = iSeq(j)
            val aokiVecOpt = aokiMap.get(indexAoki)

            if (aokiVecOpt.isEmpty && takahashiVec.isEmpty) {

            } else if(aokiVecOpt.isEmpty) {
              b2.break()
            }  else {
                val aokiVec = aokiVecOpt.get.map(aoki => {
                  iSeq.indexOf(aoki)
                }).sorted
                if (takahashiVec != aokiVec) {
                  b2.break()
                }
              }


          })
          result = true
          b1.break()
        }
      })
    }

    if (result) {
      println("Yes")
    } else {
      println("No")
    }
  }
}
