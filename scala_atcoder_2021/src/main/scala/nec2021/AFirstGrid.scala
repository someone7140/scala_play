package nec2021

object AFirstGrid extends App {
  val s1 = scala.io.StdIn.readLine()
  val s2 = scala.io.StdIn.readLine()
  val combine = if (s1(0).toString == "#" && s1(0).toString == s2(0).toString) {
     s1(1).toString() + s1(0).toString + s2
  } else {
    s1 + s2(1).toString() + s2(0).toString
  }
  var findFlag = false
  var before = ""
  var result = "Yes"
  combine.foreach(s => {
    val sString = s.toString
    if (sString == "#") {
      if (findFlag && before == ".") {
        result = "No"
      }
      findFlag = true
    }
    before = sString
  })
  println(result)
}
