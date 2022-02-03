package beginnerContest237

object ANotOverflow extends App {
  val n = scala.io.StdIn.readLong()

  if (n < 2147483648L && n >= -2147483648L) {
    println("Yes")
  } else {
    println("No")
  }

}
