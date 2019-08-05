package beginnerContest136

// https://atcoder.jp/contests/abc136/tasks/abc136_b

object BUnevenNumbers extends App {
  val n = scala.io.StdIn.readLine()
  println(
    (1 to n.length).map { i =>
      if ( i % 2 == 0){
        0
      } else {
        var count = 0
        if(i == n.length) {
          count = n.toInt - Math.pow(10, n.length - 1).toInt
          count = count + 1
        } else {
          count = Math.pow(10, i).toInt - Math.pow(10, i - 1).toInt
        }
        count
      }
    }.sum
  )
}
