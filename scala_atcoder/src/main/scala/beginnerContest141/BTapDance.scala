package beginnerContest141

// https://atcoder.jp/contests/abc141/tasks/abc141_b

import scala.util.control.Breaks

object BTapDance extends App {
  val s =  scala.io.StdIn.readLine()
  val b = new Breaks
  var result = "Yes"
  b.breakable{
    s.zipWithIndex.foreach { case(w, i) =>
      if ((i + 1) % 2 == 0) {
        if(w !='L' && w != 'U' && w != 'D') {
          result = "No"
          b.break
        }
      } else {
        if(w !='R' && w != 'U' && w != 'D') {
          result = "No"
          b.break
        }
      }
    }
  }
  println(result)
}
