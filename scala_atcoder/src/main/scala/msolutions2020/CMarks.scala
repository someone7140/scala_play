package msolutions2020

// https://atcoder.jp/contests/m-solutions2020/tasks/m_solutions2020_c

object CMarks extends App {
  val nkInput = scala.io.StdIn.readLine()
  val nkArray =  nkInput.split(" ").map(_.toInt).toVector
  val n = nkArray(0)
  var k = nkArray(1)

  val aInput = scala.io.StdIn.readLine()
  val aArray =  aInput.split(" ").map(_.toLong).toVector

  var hikakuMotoIndex = 0

  (k to n - 1).foreach { i =>
    val hikakuSaki = aArray(i)
    val hikakuMoto = aArray(hikakuMotoIndex)

    if (hikakuSaki > hikakuMoto) {
      println("Yes")
    } else {
      println("No")
    }
    hikakuMotoIndex = hikakuMotoIndex + 1
  }

}
