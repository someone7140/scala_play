package keyence2021

object BKEYENCEbuilding extends App {
  val n = scala.io.StdIn.readInt()
  val aVector = scala.io.StdIn.readLine().split(" ").map(_.toInt).toVector
  var mensekiSet = Set.empty[Int]

  (1 to 150).foreach(i => {
    (1 to 150).foreach(j => {
      val temp = 4 * i * j + 3 * i + 3 * j
      if (temp <= 1000) {
        mensekiSet += temp
      }
    })
  })
  println(aVector.filter(a => !mensekiSet.contains(a)).size)
}
