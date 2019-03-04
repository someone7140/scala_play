package beginnerContest120

// https://atcoder.jp/contests/abc120/tasks/abc120_b

object BKthCommonDivisor extends App {
  var input = scala.io.StdIn.readLine()
  val abkArray =  input.split(" ").map(_.toInt)
  val a = abkArray(0)
  val b = abkArray(1)
  val k = abkArray(2)
  var i = 1
  var s = 1
  var array = Vector.empty[Int]

  while (s <= a && s <= b)  {
    if (a % s == 0 && b % s == 0) {
      array :+= s
    }
    s += 1
  }
  val arrayr = array.reverse
  print(arrayr.apply(k - 1))
}
