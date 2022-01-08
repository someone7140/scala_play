package beginnerContest234

object AWeirdFunction extends App {
  val t = scala.io.StdIn.readLong()

  def calc(input: Long): Long = {
    input * input + 2 * input + 3
  }

  val result = calc(calc(calc(t) + t) + calc(calc(t)))
  println(result)
}
