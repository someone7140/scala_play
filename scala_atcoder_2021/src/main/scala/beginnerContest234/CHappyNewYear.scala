package beginnerContest234

object CHappyNewYear extends App {
  val k = scala.io.StdIn.readLong()
  val niShinsuu = k.toBinaryString
  println(niShinsuu.replaceAll("1", "2"))
}
