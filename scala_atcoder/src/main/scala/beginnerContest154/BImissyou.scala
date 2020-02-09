package beginnerContest154

// https://atcoder.jp/contests/abc154/tasks/abc154_b

object BImissyou extends App {
  val s =  scala.io.StdIn.readLine()
  val length = s.length
  var result = ""
  (1 to length).foreach(_ => result = result + "x")
  println(result)

}
