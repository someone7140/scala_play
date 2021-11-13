package keyence2021

import scala.math._

object CABCconjecture extends App {
  val n = scala.io.StdIn.readLong()
  var result = 0L

  val nSqrt = sqrt(n).toLong + 1L

  def factorization(target: Long): Map[Long, Int] = {
    val maxDivisor = sqrt(target).toInt

    def factorizationRec(num: Long, divisor: Int, acc: Map[Long, Int]): Map[Long, Int] = {
      if (divisor > maxDivisor) {
        if (num == 1) acc else acc + (num -> 1)
      } else if (num % divisor == 0) {
        val nextAcc = acc + (divisor.toLong -> (acc.getOrElse(divisor, 0) + 1))
        factorizationRec(num / divisor, divisor, nextAcc)
      } else {
        factorizationRec(num, divisor + 1, acc)
      }
    }

    factorizationRec(target, 2, Map())
  }

  var setAb = Set.empty[Long]
  (1L to nSqrt).foreach(cWari => {
    if (n % cWari == 0) {
      val c = n / cWari
      val cSqrt = sqrt(c).toLong + 1L
      (1L to cSqrt).foreach(ab => {
        if (c % ab == 0 && !setAb.contains(ab)) {
          setAb += ab
          val cDivideAb = c / ab
          if (ab == 1) {
            result += cDivideAb
          } else {
            val abSqrt = sqrt(ab).toLong + 1L
            (1L to abSqrt).foreach(a => {
              if (ab % a == 0) {
                val b = ab / a
                if (b >= a) {
                  result += (if (b == cDivideAb)  1 else cDivideAb - b) * (if (b == a)  1 else b - a)
                }
              }
            })
          }
        }
      })
    }

  })
  println(result)
}
