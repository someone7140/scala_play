package beginnerContest160

// https://atcoder.jp/contests/abc160/tasks/abc160_a

object ACoffee extends App {
  val s =  scala.io.StdIn.readLine()
  if(s.charAt(2).toString == s.charAt(3).toString &&
     s.charAt(4).toString == s.charAt(5).toString) {
    println("Yes")
  } else {
    println("No")
  }
}
