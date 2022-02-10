package beginnerContest238

object Cdigitnum extends App {
  val n = scala.io.StdIn.readLong()
  var result = BigInt(0)
  val ketasuu = n.toString.length

  (1 to ketasuu).foreach(i => {
    if (i == ketasuu) {
      val temp2 = math.pow(10, i - 1)
      val temp = n - temp2.toLong + 1
      val plus2 = BigInt(temp) * BigInt((temp + 1L)) / BigInt(2L)
      result = (result + plus2) % BigInt(998244353)
    } else {
      val temp = math.pow(10, i)
      val temp2 = math.pow(10, i - 1)
      val plus = (temp - temp2).toLong
      val plus2 = BigInt(plus) * BigInt(plus + 1L) / BigInt(2L)
      result = (result + plus2) % BigInt(998244353)
    }
  })
  println(result)
}
