package beginnerContest244

object EKingBombee extends App {
  val nmkstxArray = scala.io.StdIn.readLine().split(" ").map(_.toInt)
  val n = nmkstxArray(0)
  val m = nmkstxArray(1)
  val k = nmkstxArray(2)
  val s = nmkstxArray(3)
  val t = nmkstxArray(4)
  val x = nmkstxArray(5)
  var result = 0L

  val dp = new Array(k)[scala.collection.mutable.Map[Int, Int]]
  dp(0) = scala.collection.mutable.Map(1 -> 0)

  def calc(index: Int, nextValue: Int): Unit = {
    if (index != k) {

    }
  }





}
