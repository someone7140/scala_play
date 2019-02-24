object SeqMinusTest{
  val seqSample = Seq(1, 2, 1, 3, 1, 4, 1, 5, 1, 6)
  def main() = {
    println(seqSample.filterNot(_ == 1))
    println(seqSample.diff(Seq(1)))
    println(seqSample.diff(Seq(1, 1)))
  }
}