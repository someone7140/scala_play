package beginnersSelection

// https://atcoder.jp/contests/abs/tasks/arc065_a

object Abc049cDaydream extends App {
  var s = scala.io.StdIn.readLine()
  val tSeq = Seq("dreamer", "eraser", "dream", "erase")

  def judgeInclude(sInput: String): Boolean = {
    var sTemp = sInput
    while(true) {
      tSeq.find(t => sTemp.endsWith(t)) match {
        case Some(t) =>
          if(t == sTemp) {
            return true
          } else {
            sTemp = sTemp.dropRight(t.length)
          }
        case _ =>
          return false
      }
    }
    return false
  }
  
  if (judgeInclude(s)) {
    println("YES")
  } else {
    println("NO")
  }
}