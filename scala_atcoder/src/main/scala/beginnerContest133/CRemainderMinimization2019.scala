package beginnerContest133

// https://atcoder.jp/contests/abc133/tasks/abc133_c

object CRemainderMinimization2019 extends App {
  val read = scala.io.StdIn.readLine()
  val arrayIJ =  read.split(" ").map(_.toLong).toVector
  if(arrayIJ(1) - arrayIJ(0) >= 2018) {
    println(0)
  } else {
    val modList = (arrayIJ(0) to arrayIJ(1)).map(_ % 2019L).sorted
    println(modList(0) * modList(1))
  }
}
