package toyotaSystems2021

import scala.util.control.Breaks

object CFinalDay extends App {
  val nkVector = scala.io.StdIn.readLine().split(" ").map(_.toInt).toVector
  val n = nkVector(0)
  val k = nkVector(1)

  var pArray = new Array[(Int, Int)](n)
  (1 to n).foreach(i => {
    val pSum = scala.io.StdIn.readLine().split(" ").map(_.toInt).sum
    pArray(i - 1) = (i - 1, pSum)
  })

  val pArrayDesc = pArray.sortBy(_._2).reverse
  var ruisekiSabun = 0
  var beforeValue = 0
  var beforeStatus = "Yes"
  var nowPosition = 1
  val pArrayWithResult = pArrayDesc.zipWithIndex.map(p => {
    var result = (0, "")
    if (p._2 == 0) {
      result = (p._1._1, "Yes")
    } else if (beforeStatus == "No") {
      result = (p._1._1, "No")
    } else {
      val sabun = beforeValue - p._1._2
      if(sabun > 300) {
        result = (p._1._1, "No")
        ruisekiSabun = sabun + ruisekiSabun
      } else {
        ruisekiSabun = sabun + ruisekiSabun
        if (ruisekiSabun <= 300) {
          result = (p._1._1, "Yes")
        } else {
          val b = new Breaks
          var index = n
          b.breakable {
            (0 to n - 1).foreach(i => {
              if (pArrayDesc(i)._2 <= (p._1._2 + 300)) {
                index = i + 1
                b.break
              }
            })
          }
          nowPosition = index
          if (nowPosition <= k) {
            ruisekiSabun = 0
            result = (p._1._1, "Yes")
          } else {
            result = (p._1._1, "No")
          }
        }
      }
    }
    beforeValue = p._1._2
    beforeStatus = result._2
    result
  })

  pArrayWithResult.sortBy(_._1).foreach(p => {
    println(p._2)
  })
}
