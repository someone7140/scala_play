package beginnerContest244

import scala.util.control.Breaks

object CYamanoteLineGame extends App {
  val n = scala.io.StdIn.readInt()
  val max = 2 * n + 1
  val b = new Breaks

  val usedMap = scala.collection.mutable.Map.empty[Int, Boolean]

  // 高橋くんの最初
  println(1)
  usedMap.put(1, true)

  // 高橋くん用の変数
  var takahashiVar = 2

  b.breakable {
    while(true) {
      val aokiInput = scala.io.StdIn.readInt()
      if (aokiInput == 0 || usedMap.get(aokiInput).isDefined) {
        b.break()
      } else {
        usedMap.put(aokiInput, true)
        val b2 = new Breaks
        b2.breakable {
          (takahashiVar to max).foreach(i => {
            if (usedMap.get(i).isEmpty) {
              usedMap.put(i, true)
              println(i)
              takahashiVar = i + 1
              b2.break()
            }
          })
        }
      }
    }
  }
}
