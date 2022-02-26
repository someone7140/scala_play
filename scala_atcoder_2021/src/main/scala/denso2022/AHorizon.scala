package denso2022

import scala.math.sqrt

object AHorizon extends App {
  val h = scala.io.StdIn.readDouble()
  val result = sqrt(h * (h + 12800000))
  println(result)
}
