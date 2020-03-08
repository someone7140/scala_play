package hitachi2020

// https://atcoder.jp/contests/hitachi2020/tasks/hitachi2020_a

object AHitachiString extends App {
  val s =  scala.io.StdIn.readLine()
  if(s.length % 2 == 0) {
    var tempS = s
    var yesFlag = true
    while(tempS.length > 0) {
      if (tempS.substring(0, 2) != "hi") {
        yesFlag = false
        tempS = ""
      } else {
        if(tempS.length > 3) {
          tempS = tempS.substring(2)
        } else {
          tempS = ""
        }
      }
    }
    if (yesFlag) println("Yes") else println("No")
  } else {
    println("No")
  }

}
