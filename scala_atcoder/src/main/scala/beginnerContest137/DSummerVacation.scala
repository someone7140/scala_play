package beginnerContest137

// https://atcoder.jp/contests/abc137/tasks/abc137_d

object DSummerVacation extends App {
  val readNm = scala.io.StdIn.readLine()
  val array = readNm.split(" ").map(_.toInt).toVector
  val n = array(0)
  val m = array(1)
  var abArray = Vector.empty[Vector[Int]]
  (1 to n).foreach { _ =>
    val readAb = scala.io.StdIn.readLine()
    abArray :+= readAb.split(" ").map(_.toInt).toVector
  }
  println(abArray)
  val abArraySorted = abArray.filter(ab => ab(0) <= m).sortWith((ab1, ab2) =>
    if (ab1(1) == ab2(1)) {
      ab1(0) > ab2(0)
    } else {
      ab1(1) > ab2(1)
    }
  )
  println(abArraySorted)
}
