package beginnerContest139

// https://atcoder.jp/contests/abc139/tasks/abc139_a

object ATenki extends App {
  val s =  scala.io.StdIn.readLine()
  val t =  scala.io.StdIn.readLine()
  println(
    s.zipWithIndex.filter(w => w._1 == t.charAt(w._2)).size
  )
}
