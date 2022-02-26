package denso2022

object BIntegerDivision extends App {
  val x = scala.io.StdIn.readLong()
  val wari = x / 10L
  val amari = x % 10L
  var result = 0L

  if (x < 0 && amari != 0) {
    result = wari - 1L
  } else {
    result = wari
  }

  println(result)
}
