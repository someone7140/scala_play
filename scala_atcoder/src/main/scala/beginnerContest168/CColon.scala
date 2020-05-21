package beginnerContest168

// https://atcoder.jp/contests/abc168/tasks/abc168_c

object CColon extends App {
  val abhm = scala.io.StdIn.readLine()
  val abhmaArray = abhm.split(" ").map(_.toInt).toSeq
  val a = abhmaArray(0)
  val b = abhmaArray(1)
  val h = abhmaArray(2)
  val m = abhmaArray(3)
  val hDegree = h * 30 + m * 0.5
  val mDegree = (m * 6).toDouble

  var triangleDegree = 0d
  if(hDegree > mDegree) {
    triangleDegree =
      if (hDegree - mDegree > 180d) {
        360d - hDegree + mDegree
      } else {
        hDegree - mDegree
      }
  } else {
    triangleDegree =
      if (mDegree - hDegree > 180d) {
        360d - mDegree + hDegree
      } else {
        mDegree - hDegree
      }
  }
  if (triangleDegree == 0d) {
    println(Math.abs(a - b))
  } else if (triangleDegree == 180d) {
    println(a + b)
  } else {
    println(Math.sqrt(a * a + b * b - 2d * a * b * Math.cos(Math.toRadians(triangleDegree))))
  }

}
