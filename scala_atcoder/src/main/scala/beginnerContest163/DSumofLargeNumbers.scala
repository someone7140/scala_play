package beginnerContest163

// https://atcoder.jp/contests/abc163/tasks/abc163_d

object DSumofLargeNumbers extends App {
  val nk =  scala.io.StdIn.readLine()
  val nkArray = nk.split(" ").map(_.toInt).toSeq
  val n = nkArray(0)
  val k = nkArray(1)
  val e = 1000000007L
  var set = scala.collection.mutable.Set.empty[Long]

  (k to n + 1).foreach { s =>
    (0 to n).combinations(s).foreach { c =>
      set.add(c.map(_.toLong + 1000L).sum)
    }
  }

  println(set.size.toLong % e)

}