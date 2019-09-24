package beginnerContest141

// https://atcoder.jp/contests/abc141/tasks/abc141_c

object CAttackSurvival extends App {
  val inputnkq = scala.io.StdIn.readLine()
  val nkqArray = inputnkq.split(" ").map(_.toInt).toVector

  val n = nkqArray(0)
  val k = nkqArray(1)
  val q = nkqArray(2)

  var answerMap = scala.collection.mutable.Map.empty[Int, Int]
  (1 to q).foreach { _ =>
    val a = scala.io.StdIn.readInt()
    answerMap.get(a).fold(answerMap.put(a, 1))(v => answerMap.put(a, v + 1))
  }

  (1 to n).foreach { i =>
    answerMap.get(i).fold {
      if ( (k - q) > 0 ) {
        println("Yes")
      } else {
        println("No")
      }
    } { a =>
      if ( (k - q + a) > 0 ) {
        println("Yes")
      } else {
        println("No")
      }
    }
  }

}
