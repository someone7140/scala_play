package nec2021

object BHardCalculation extends App {
  val ab = scala.io.StdIn.readLine().split(" ")
  val a = ab(0)
  val b = ab(1)

  val shorter = if (a.length < b.length) {
    a.reverse
  } else {
    b.reverse
  }
  val longer = if (a.length < b.length) {
    b.reverse
  } else {
    a.reverse
  }

  var result = "Easy"
  shorter.zipWithIndex.foreach(s => {
    val index = s._2
    val shorterNumber = s._1.toString.toInt
    val longerNumber = longer(index).toString.toInt
    if (shorterNumber + longerNumber >= 10) {
      result = "Hard"
    }
  })

  println(result)
}
