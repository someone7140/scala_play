package tokyoKaijo2020

// https://atcoder.jp/contests/tokiomarine2020/tasks/tokiomarine2020_b

object BTag extends App {
  val a =  scala.io.StdIn.readLine()
  val aArray = a.split(" ").map(_.toLong).toSeq
  val aPos = aArray(0)
  val aHayasa = aArray(1)

  val b =  scala.io.StdIn.readLine()
  val bArray = b.split(" ").map(_.toLong).toSeq
  val bPos = bArray(0)
  val bHayasa = bArray(1)

  val t = scala.io.StdIn.readLong()

  val max = 1000000000
  var sabun = 0L
  var maxSabun = 0L

  if (aPos < 0L && bPos >= 0L) {
    sabun = bPos - aPos
    maxSabun = max - aPos
  } else if (aPos >= 0L && bPos < 0L) {
    sabun = aPos - bPos
    maxSabun = max + aPos
  } else {
    sabun = Math.abs(bPos - aPos)
    maxSabun = max - Math.abs(aPos)
  }

  if (sabun - (aHayasa * t - bHayasa * t) <= 0L) {
    println("YES")
  } else {
    //if (maxSabun - aHayasa * t <= 0L) {
    //  println("YES")
    //} else {
    //  println("NO")
    //}
    println("NO")
  }
}
