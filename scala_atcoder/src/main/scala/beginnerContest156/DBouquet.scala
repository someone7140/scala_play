package beginnerContest156

// https://atcoder.jp/contests/abc156/tasks/abc156_d

object DBouquet extends App {
  val nabInput =  scala.io.StdIn.readLine()
  val nabArray = nabInput.split(" ").map(_.toInt).toVector

  val max = 1000000007L

  val n = nabArray(0)
  val a = nabArray(1)
  val b = nabArray(2)

  val combArray = {
    val arr = Array.ofDim[Long](n + 1, n + 1)
    val loopMax = arr.length - 1
    (0 to loopMax).foreach { i =>
      arr(i)(0) = 1L;
      arr(i)(i) = 1L;
    }
    (1 to loopMax).foreach { j =>
      (1 to j - 1).foreach { k =>
        arr(j)(k) = (arr(j - 1)(k - 1) + arr(j - 1)(k)) % 1000000007L
      }

    }
    arr
  }

  var result = 0L

  (1 to n).foreach { i =>
    if(i != a && i != b) {
      result = (result + combArray(n)(i)) % 1000000007L
    }
  }
  println(result)
}
