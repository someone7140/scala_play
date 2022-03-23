package beginnerContest244

object DSwapHats extends App {
  val sArray = scala.io.StdIn.readLine().split(" ")
  val tArray = scala.io.StdIn.readLine().split(" ")

  if (sArray(0) == tArray(0)) { // 最初の文字が一緒
    if (sArray(1) == tArray(1)) { // 二文字目が一緒
      println("Yes")
    } else {
      println("No")
    }
  } else if (sArray(1) == tArray(0)) { // 二文字目と最初の文字が最初
    if (sArray(2) == tArray(2)) { // 三文字目が一緒
      println("No")
    } else {
      println("Yes")
    }
  } else { // 最初の文字と三文字目の文字が最初
    if (sArray(1) == tArray(1)) { // 二文字目が一緒
      println("No")
    } else {
      println("Yes")
    }
  }
}
