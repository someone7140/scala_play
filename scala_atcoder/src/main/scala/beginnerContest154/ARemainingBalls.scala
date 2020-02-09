package beginnerContest154

// https://atcoder.jp/contests/abc154/tasks/abc154_a

object ARemainingBalls extends App {
  val stInput =  scala.io.StdIn.readLine()
  val stArray = stInput.split(" ").toSeq
  val abInput =  scala.io.StdIn.readLine()
  val abArray = abInput.split(" ").map(_.toInt).toSeq
  val u =  scala.io.StdIn.readLine()
  if(u == stArray(0)) {
    println((abArray(0) - 1) + " " + abArray(1))
  } else {
    println(abArray(0) + " " + (abArray(1) - 1))
  }

}
