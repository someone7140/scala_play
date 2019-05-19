package beginnerContest126

// https://atcoder.jp/contests/abc126/tasks/abc126_b

object BYYMMorMMYY extends App {
  val read = scala.io.StdIn.readLine()
  val v1 = (read(0).toString + read(1).toString).toInt
  val v2 = (read(2).toString + read(3).toString).toInt

  def isMonth(i: Int):Boolean = {
    i < 13 && i > 0
  }

  if (isMonth(v1) && isMonth(v2)) {
    print("AMBIGUOUS")
  } else if (isMonth(v1)) {
    print("MMYY")
  } else if (isMonth(v2)) {
    print("YYMM")
  } else {
    print("NA")
  }
}
