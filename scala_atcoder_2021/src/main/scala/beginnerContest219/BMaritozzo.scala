package beginnerContest219

object BMaritozzo extends App {
  val s1 = scala.io.StdIn.readLine();
  val s2 = scala.io.StdIn.readLine();
  val s3 = scala.io.StdIn.readLine();
  val t = scala.io.StdIn.readLine();

  var result = ""
  t.foreach(c => {
    val index = c.toString.toInt
    if (index == 1) {
      result = result + s1
    } else if (index == 2) {
      result = result + s2
    } else {
      result = result + s3
    }
  })

  println(result)

}
