
object NumericWideningCeil extends App {
  val ceil = Math.ceil((100d / 3d * 2d) * 10d)
  println(ceil)
  println(ceil.getClass)
  val test = Math.ceil((100d / 3d * 2d) * 10d) / 10d
  println(test)
  println(test.getClass)
}
