package beginnerContest236

object CRouteMap extends App {
  val nmVector = scala.io.StdIn.readLine().split(" ").map(_.toInt).toVector
  val n = nmVector(0)
  val m = nmVector(1)

  val sVector = scala.io.StdIn.readLine().split(" ").toVector
  val tVector = scala.io.StdIn.readLine().split(" ").toVector
  val tMap = scala.collection.mutable.Map.empty[String, Boolean]
  tVector.foreach(t => {
    tMap.put(t, true)
  })

  val resultVector = sVector.map(s => {
    val mapOpt = tMap.get(s)
    mapOpt.fold("No")(_ => "Yes")
  })

  println(resultVector.mkString(System.lineSeparator))
}
