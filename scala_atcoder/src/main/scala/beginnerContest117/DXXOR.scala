package beginnerContest117

// https://atcoder.jp/contests/abc117/tasks/abc117_d

import scala.math.pow

object DXXOR extends App {
  var nk = scala.io.StdIn.readLine()
  var nk1 = nk.split(" ")
  val n = nk1(0).toInt
  val k = nk1(1).toLong
  var a = scala.io.StdIn.readLine()
  val aArray =  a.split(" ").toVector.map(_.toLong)

  def getXorLong(i1:Long, i2:Long) :Long = {
    val input1 = i1.toBinaryString
    val input2 = i2.toBinaryString
    var result = ""
    var length1 = 0
    var length2 = 0
    val baseInput = {
      if (input1.length > input2.length) {
        length1 = input1.length
        length2 = input2.length
        (input1, input2)
      } else {
        length1 = input2.length
        length2 = input1.length
        (input2, input1)
      }
    }

    for(i<-0 to length1 - 1) {
      if (i > length2 - 1) {
        if(baseInput._1.toString.charAt(length1 - (i + 1)) == '1') {
          result = "1" + result
        } else {
          result = "0" + result
        }
      } else {
        result = {
          if (baseInput._1.toString.charAt(length1 - (i + 1)) == baseInput._2.toString.charAt(length2 - (i + 1))) {
            "0" + result
          } else {
            "1" + result
          }
        }
      }
    }
    var resultLong:Long = 0L
    for(i<-0 to length1 - 1) {
      if( result.charAt(length1 - 1 - i) == '1' ) {
        resultLong += pow(2 ,i).toLong
      }
    }
    resultLong
  }

  var maxSum:Long = 0L
  for(i<-0L to k) {
    val tempSum:Long = aArray.map(a=> getXorLong(i, a)).sum
    if(tempSum > maxSum) {
      maxSum = tempSum
    }
  }
  print(maxSum)
}
