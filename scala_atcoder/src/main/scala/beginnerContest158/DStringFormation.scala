package beginnerContest158

// https://atcoder.jp/contests/abc158/tasks/abc158_d

object DStringFormation extends App {
  val s = scala.io.StdIn.readLine()
  val q = scala.io.StdIn.readInt()
  def hanten(input: Vector[String]) = {
    input.reverse
  }

  var result = Vector(s)
  var hantenFlg = false
  (1 to q).foreach { _ =>
    val query = scala.io.StdIn.readLine()
    if (query == "1") {
      hantenFlg = if (hantenFlg) false else true
    } else {
      val querySplit = query.split(" ")
      if (querySplit(1) == "1") {
        result = Vector(querySplit(2)) ++ (if (hantenFlg) hanten(result) else result)
      } else {
        result = (if (hantenFlg) hanten(result) else result) ++ Vector(querySplit(2))
      }
      hantenFlg = false
    }
  }

  println({if (hantenFlg) hanten(result) else result}.mkString)
}
