package beginnerContest118

// https://atcoder.jp/contests/abc118/tasks/abc118_c

object CMonstersBattleRoyale extends App {
  var n = scala.io.StdIn.readInt()
  var a = scala.io.StdIn.readLine()
  val aArray =  a.split(" ").map(_.toInt).toVector
  val amin = aArray.min

  def judgeMinArray(array: Vector[Int], min: Int):Int = {
    val divideResult = array.map(a=> a % min)
    val divideResultMax = divideResult.max
    if(divideResultMax == 0) {
      min
    } else {
      val divideResultMinWithOutZero = divideResult.filter(_ != 0).min
      if(divideResultMinWithOutZero == 1) {
        1
      } else {
        judgeMinArray(aArray, divideResultMax)
      }
    }
  }
  println(judgeMinArray(aArray, amin))
}
