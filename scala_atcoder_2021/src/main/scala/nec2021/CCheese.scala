package nec2021

object CCheese extends App {
  val nw = scala.io.StdIn.readLine().split(" ").map(_.toInt).toVector
  val n = nw(0)
  val w = nw(1)

  var abArray = new Array[(Int, Int)](n)
  (0 to n - 1).foreach(i => {
    val ab = scala.io.StdIn.readLine().split(" ").map(_.toInt).toVector
    abArray(i) = (ab(0), ab(1))
  })

  val abArraySorted = abArray.sortBy(_._1).reverse
  var countW = 0
  var result = 0L
  abArraySorted.foreach(ab => {
    val a = ab._1
    val b = ab._2
    val plusEnable = w - countW
    if (plusEnable > 0) {
      if (plusEnable >= b) {
        result = result + (a.toLong * b.toLong)
        countW = countW + b
      } else {
        result = result + (a.toLong * plusEnable.toLong)
        countW = countW + plusEnable
      }
    }
  })
  println(result)
}
