package denso2022

object DPrimeSumGame extends App {
  val xyVector = scala.io.StdIn.readLine().split(" ").map(_.toInt).toVector
  val a = xyVector(0)
  val b = xyVector(1)
  val c = xyVector(2)
  val d = xyVector(3)

  // 約数を求める
  def divisors(n: Int): List[Int] =
    for (i <- (1 to n).toList if n % i == 0) yield i

  // 約数が2のときは素数
  def isPrime(n: Int): Boolean = divisors(n).lengthCompare(2) == 0

  // 与えられた整数までの素数のリストを返す
  def findPrimeUntil(n: Int): Iterable[Int] = {
    for (i <- 1 to n if isPrime(i)) yield i
  }

  var sosuuMap = scala.collection.mutable.Map[Int, Boolean]()
  findPrimeUntil(200).foreach(i => {
    sosuuMap.put(i , true)
  })

  var result = "Aoki"

  (a to b).foreach(ab => {
    var sosuuFind = false
    (c to d).foreach(cd => {
      val findOpt = sosuuMap.get(ab + cd)
      if (findOpt.isDefined) {
        sosuuFind = true
      }
    })
    if (!sosuuFind) {
      result = "Takahashi"
    }
  })

  println(result)
}
