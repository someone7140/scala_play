package hitachi2020

// https://atcoder.jp/contests/hitachi2020/tasks/hitachi2020_c

object CThREE extends App {
  val n = scala.io.StdIn.readInt()
  var keyArray = Vector.empty[Int]
  var pMap = scala.collection.mutable.Map.empty[Int, Vector[Int]]
  var cMap = scala.collection.mutable.Map.empty[Int, Vector[Int]]

  (1 to n - 1).foreach { _ =>
    val abInput  = scala.io.StdIn.readLine()
    val abInputArray = abInput.split(" ").map(_.toInt).toSeq
    val a = abInputArray(0)
    val b = abInputArray(1)

    keyArray :+= a
    if (pMap.contains(a)) {
      val parentVector = pMap.get(a).get
      pMap.put(b, parentVector ++ Vector(a))
    } else {
      pMap.put(b, Vector(a))
    }
    if (cMap.contains(a)) {
      val childVector = cMap.get(a).get
      cMap.put(a, childVector ++ Vector(b))
    } else {
      cMap.put(a, Vector(b))
    }
  }
  var threeArray = Vector.empty[(Int, Int)]
  pMap.keys.foreach { k =>
    val parents = pMap.get(k).get
    if (parents.length >= 3) {
      threeArray :+= (parents(parents.length - 3), k)
    }
    if (parents.length >= 2) {
      val twoAboveParent = parents(parents.length - 2)
      val oneChildVector = cMap.get(twoAboveParent).get
      oneChildVector.filter(c => !parents.exists(p => p == c)).map(c =>
        threeArray :+= (c, k)
      )
    }
  }
  if(threeArray.isEmpty) {
    println(keyArray.mkString(" "))
  } else {
    println(threeArray)
  }
}
