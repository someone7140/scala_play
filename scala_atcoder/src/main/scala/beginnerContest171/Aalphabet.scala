package beginnerContest171

// https://atcoder.jp/contests/abc171/tasks/abc171_a

object Aalphabet extends App {
  val alpha =  scala.io.StdIn.readLine()
  val ohMojiPattern = "[A-Z]".r
  if (ohMojiPattern.findFirstMatchIn(alpha).isEmpty) {
    println("a")
  } else {
    println("A")
  }
}
