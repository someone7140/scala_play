package beginnerContest116

// https://atcoder.jp/contests/abc116/tasks/abc116_b

object BCollatzProblem extends App {
  var s = scala.io.StdIn.readInt()
  var seqInt = Seq(s)

  def nextJudge(i: Int): Unit = {
    var nextInt = 0
    if(i % 2 == 0) {
      nextInt = i / 2
    } else {
      nextInt = 3 * i + 1
    }
    seqInt.find(_ == nextInt).fold
      {seqInt :+= nextInt
       nextJudge(nextInt)
      }
      {_=> println(seqInt.size + 1)}
  }
  nextJudge(s)
}