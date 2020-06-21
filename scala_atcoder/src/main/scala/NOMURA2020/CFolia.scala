package NOMURA2020

// https://atcoder.jp/contests/nomura2020/tasks/nomura2020_c

import scala.util.control.Breaks

object CFolia extends App {
  val n =  scala.io.StdIn.readInt()
  val a = scala.io.StdIn.readLine()
  val aVector = a.split(" ").map(_.toInt).toVector

  def judgeResult(nowPos: Int, afterCount: (Int, Int)): (Int, Int) = {
    return (afterCount._1 - afterCount._2 + nowPos, nowPos)
  }

  var afterCount = (0, 0)
  if (aVector.head != 0) {
    println(-1)
  } else {
    val b = new Breaks
    var result = 0
    var i = n
    b.breakable {
      while(i >= 0) {
        if (i == 0) {
          result = result + 1
        } else if (i == 1) {
          val nowPos = aVector(i)
          if (nowPos > 2) {
            result = - 1
            b.break()
          } else {
            val tempResult = judgeResult(nowPos, afterCount)
            if (tempResult._1 < 1) {
              result = - 1
              b.break()
            } else {
              result = result + tempResult._1
            }
          }
        } else if(i == n) {
          val temp = aVector(i)
          result = result + temp
          afterCount = (temp, 0)
        } else if(i == n - 1) {
          result = result + afterCount._1
          afterCount = (afterCount._1, aVector(i))
        } else {
          val tempResult = judgeResult(aVector(i), afterCount)
          if (tempResult._1 < 1) {
            result = - 1
            b.break()
          } else {
            result = result + tempResult._1
          }
          afterCount = tempResult
        }
      i = i - 1
      }
    }
    println(result)
  }
}
