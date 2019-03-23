package grandContest032

// https://atcoder.jp/contests/agc032/tasks/agc032_a

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks

object ALimitedInsertion extends App {
  val n = scala.io.StdIn.readInt()
  var inputB = scala.io.StdIn.readLine()
  val bArray =  inputB.split(" ").map(_.toInt)
  var resultArray = ArrayBuffer.empty[Int]
  var inputVector = Vector.empty[Int]
  var bArrayBuffer = bArray.reverse.toBuffer
  val b = new Breaks
  b.breakable{
    for(i<-0 to (n-1)) {
      if (i == 0 ) {
        val lastOneIndex = bArrayBuffer.lastIndexOf(1)
        if (lastOneIndex < 0) {
          b.break
        } else {
          val v = bArrayBuffer.remove(lastOneIndex)
          inputVector :+= v
          resultArray.insert(v - 1, v)
        }
      } else {
        val v = bArrayBuffer.remove(0)
        inputVector :+= v
        resultArray.insert(v - 1, v)
      }
    }
  }

  if (resultArray.length != n) {
    print(-1)
  } else if (resultArray.toList != bArray.toList) {
    print(-1)
  } else {
    inputVector.foreach(println(_))
  }
}
