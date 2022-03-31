package beginnerContest245

import scala.math.abs
import scala.util.control.Breaks

object CChooseElements extends App {
  val nkArray = scala.io.StdIn.readLine().split(" ").map(_.toInt)
  val n = nkArray(0)
  val k = nkArray(1)

  val aArray = scala.io.StdIn.readLine().split(" ").map(_.toInt)
  val bArray = scala.io.StdIn.readLine().split(" ").map(_.toInt)

  val hikauArray = new Array[String](n)

  hikauArray(0) = "ab"
  var falseFlag = false

  val break = new Breaks
  break.breakable {
    (1 to (n - 1)).foreach(i => {
      val before = i  - 1
      val hikaku = hikauArray(before)

      val a = aArray(i)
      val b = bArray(i)
      val aBefore = aArray(before)
      val bBefore = bArray(before)

      var tempHikaku = ""
      val aSabunA = abs(a - aBefore) <= k
      val aSabunB = abs(a - bBefore) <= k
      val bSabunA = abs(b - aBefore) <= k
      val bSabunB = abs(b - bBefore) <= k
      if (hikaku == "ab") {
        if (aSabunA || aSabunB) {
          tempHikaku = tempHikaku + "a"
        }
        if (bSabunA || bSabunB) {
          tempHikaku = tempHikaku + "b"
        }
      } else if (hikaku == "a") {
        if (aSabunA) {
          tempHikaku = tempHikaku + "a"
        }
        if (bSabunA) {
          tempHikaku = tempHikaku + "b"
        }
      } else {
        if (aSabunB) {
          tempHikaku = tempHikaku + "a"
        }
        if (bSabunB) {
          tempHikaku = tempHikaku + "b"
        }
      }
      if (tempHikaku == "") {
        falseFlag = true
        break.break()
      } else {
        hikauArray(i) = tempHikaku
      }
    })
  }

  if (falseFlag) {
    println("No")
  } else {
    println("Yes")
  }

}
