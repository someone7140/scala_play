
object GroupBy extends App {
  val testSeq = Seq(2.1, 3.1, 5.1, 2.1, 3.1, 3.1)
  testSeq.groupBy(n => n).foreach { case(k, v) =>
    println(s"${k}:${v.size}")
  }
}
