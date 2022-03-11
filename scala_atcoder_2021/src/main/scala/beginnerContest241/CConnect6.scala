package beginnerContest241

import scala.util.control.Breaks

object CConnect6 extends App {
  val n = scala.io.StdIn.readInt()
  var sArrayArray = new Array[Array[String]](n)

  (0 to n - 1).foreach(i => {
    val sInput = scala.io.StdIn.readLine()
    sArrayArray(i) = sInput.toCharArray.map(c => c.toString)
  })

  def rowJudge(rowIndex: Int, colIndex: Int): Boolean = {
    var resultRow = true
    // 行く方向
    var houkou = "plus"
    var tempRowIndex = rowIndex
    var penartyCount = 2

    val b = new Breaks

    b.breakable {
      (1 to 6).foreach(_ => {
        if (sArrayArray(tempRowIndex)(colIndex) != "#") {
          penartyCount = penartyCount - 1
        }
        if (penartyCount < 0) {
          resultRow = false
          b.break()
        }
        if (houkou == "plus") {
          if (tempRowIndex == n - 1) {
            houkou = "minus"
            tempRowIndex = rowIndex - 1
          } else {
            tempRowIndex = tempRowIndex + 1
          }
        } else {
          tempRowIndex = tempRowIndex - 1
        }
      })
    }
    resultRow
  }

  def colJudge(rowIndex: Int, colIndex: Int): Boolean = {
    var resultCol = true
    // 行く方向
    var houkou = "plus"
    var tempColIndex = colIndex
    var penartyCount = 2

    val b = new Breaks

    b.breakable {
      (1 to 6).foreach(_ => {
        if (sArrayArray(rowIndex)(tempColIndex) != "#") {
          penartyCount = penartyCount - 1
        }
        if (penartyCount < 0) {
          resultCol = false
          b.break()
        }
        if (houkou == "plus") {
          if (tempColIndex == n - 1) {
            houkou = "minus"
            tempColIndex = colIndex - 1
          } else {
            tempColIndex = tempColIndex + 1
          }
        } else {
          tempColIndex = tempColIndex - 1
        }
      })
    }
    resultCol
  }

  def rightNanameJudge(rowIndex: Int, colIndex: Int): Boolean = {
    var resultRightNaname = true
    // 行く方向
    var houkou = "plus"
    var tempRowIndex = rowIndex
    var tempColIndex = colIndex
    var penartyCount = 2

    val b = new Breaks

    b.breakable {
      (1 to 6).foreach(_ => {
        if (tempColIndex < 0 || tempRowIndex < 0) {
          resultRightNaname = false
          b.break()
        }
        if (sArrayArray(tempRowIndex)(tempColIndex) != "#") {
          penartyCount = penartyCount - 1
        }
        if (penartyCount < 0) {
          resultRightNaname = false
          b.break()
        }
        if (houkou == "plus") {
          if (tempColIndex == n - 1 || tempRowIndex == n - 1) {
            houkou = "minus"
            tempColIndex = colIndex - 1
            tempRowIndex = rowIndex - 1
          } else {
            tempColIndex = tempColIndex + 1
            tempRowIndex = tempRowIndex + 1
          }
        } else {
          tempColIndex = tempColIndex - 1
          tempRowIndex = tempRowIndex - 1
        }
      })
    }
    resultRightNaname
  }

  def leftNanameJudge(rowIndex: Int, colIndex: Int): Boolean = {
    var resultLeftNaname = true
    // 行く方向
    var houkou = "plus"
    var tempRowIndex = rowIndex
    var tempColIndex = colIndex
    var penartyCount = 2

    val b = new Breaks

    b.breakable {
      (1 to 6).foreach(_ => {
        if (tempColIndex > n - 1 || tempRowIndex < 0) {
          resultLeftNaname = false
          b.break()
        }
        if (sArrayArray(tempRowIndex)(tempColIndex) != "#") {
          penartyCount = penartyCount - 1
        }
        if (penartyCount < 0) {
          resultLeftNaname = false
          b.break()
        }
        if (houkou == "plus") {
          if (tempColIndex == 0 || tempRowIndex == n - 1) {
            houkou = "minus"
            tempColIndex = colIndex + 1
            tempRowIndex = rowIndex - 1
          } else {
            tempColIndex = tempColIndex - 1
            tempRowIndex = tempRowIndex + 1
          }
        } else {
          tempColIndex = tempColIndex + 1
          tempRowIndex = tempRowIndex - 1
        }
      })
    }
    resultLeftNaname
  }

  var result = "No"
  val b = new Breaks

  b.breakable {
    sArrayArray.zipWithIndex.foreach(sArray => {
      val rowIndex = sArray._2
      sArray._1.zipWithIndex.foreach(s => {
        if (s._1 == "#") {
          val colIndex = s._2
          // 行判定
          val rowResult = rowJudge(rowIndex, colIndex)
          if (rowResult) {
            result = "Yes"
            b.break()
          }
          //　列判定
          val colResult = colJudge(rowIndex, colIndex)
          if (colResult) {
            result = "Yes"
            b.break()
          }
          // 右斜め判定
          val resultRightNaname = rightNanameJudge(rowIndex, colIndex)
          if (resultRightNaname) {
            result = "Yes"
            b.break()
          }
          // 左斜め判定
          val resultLeftNaname = leftNanameJudge(rowIndex, colIndex)
          if (resultLeftNaname) {
            result = "Yes"
            b.break()
          }
        }
      })
    })
  }
  println(result)
}
