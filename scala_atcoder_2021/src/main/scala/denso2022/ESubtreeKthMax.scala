package denso2022

import scala.collection.mutable


object ESubtreeKthMax extends App {
  val nqVector = scala.io.StdIn.readLine().split(" ").map(_.toInt).toVector
  val n = nqVector(0)
  val q = nqVector(1)

  val choutenList  = scala.io.StdIn.readLine()

  var abMap = scala.collection.mutable.Map[Int, Set[Int]]()
  (1 to n - 1).foreach(_ => {
    val abVector = scala.io.StdIn.readLine().split(" ").map(_.toInt).toVector
    val a = abVector(0)
    val b = abVector(1)

    val aSetOpt = abMap.get(a)
    if (aSetOpt.isDefined) {
      abMap.put(a, aSetOpt.get + b)
    } else {
      abMap.put(a, Set(b))
    }

    val bSetOpt = abMap.get(b)
    if (bSetOpt.isDefined) {
      abMap.put(b, bSetOpt.get + a)
    } else {
      abMap.put(b, Set(a))
    }
  })

  val resultList = new Array[Int](q)

  (0 to q - 1).foreach(i => {
    val qVector = scala.io.StdIn.readLine().split(" ").map(_.toInt).toVector
    val chouten = qVector(0)
    val order = qVector(1)

    var verifiedMap = scala.collection.mutable.Map[Int,Boolean]()

    val ordering = Ordering[Int].reverse
    val treeSet = mutable.TreeSet.empty(ordering)
    treeSet.add(chouten)
    verifiedMap.put(chouten, true)

    def verify(inputChouten: Int): Unit = {
      val tempSet = abMap.get(inputChouten)
      tempSet.get.foreach(j => {
        val verifyOpt = verifiedMap.get(j)
        if (verifyOpt.isEmpty) {
          verifiedMap.put(j, true)
          treeSet.add(j)
          verify(j)
        }
      })
    }
    verify(chouten)
    val treeSetArray = treeSet.toArray
    resultList(i) = treeSetArray(order - 1)
  })

  println(resultList.mkString(sep = System.lineSeparator()))
}
