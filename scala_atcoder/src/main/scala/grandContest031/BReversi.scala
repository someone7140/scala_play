package grandContest031

// https://atcoder.jp/contests/agc031/tasks/agc031_b

object BReversi extends App {
  var n = scala.io.StdIn.readInt()
  var vectorCList = Vector.empty[Vector[Int]]
  val divideVal:Long = 1000000007

  for(i <- 1 to n) {
    var newVectorCList = Vector.empty[Vector[Int]]
    val cInput = scala.io.StdIn.readLine()
    val c = cInput.toInt
    if (vectorCList.length == 0) {
      var list = Vector.empty[Int]
      list :+= c
      newVectorCList :+= list
    } else {
      for(k <- 0 to (vectorCList.length - 1)){
        var list = vectorCList(k)
        if(list.exists(_ == c) && list(list.length - 1) != c) {
          var newList = Vector.empty[Int]
          val findIndex = list.lastIndexOf(c)
          for(l <- 0 to list.length) {
            if(findIndex < l) {
              newList :+= c
            } else {
              newList :+= list(l)
            }
          }
          newVectorCList :+= newList
        }
        list :+= c
        newVectorCList :+= list
      }
    }
    vectorCList = newVectorCList.distinct
  }
  println(vectorCList.size % divideVal)
}
