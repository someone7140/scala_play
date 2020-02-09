package beginnerContest153

// https://atcoder.jp/contests/abc153/tasks/abc153_e

import scala.util.control.Breaks

object ECrestedIbisvsMonster extends App {
  val hn = scala.io.StdIn.readLine()
  val hnArray = hn.split(" ").map(_.toInt).toVector
  val h = hnArray(0)
  val n = hnArray(1)

  var abArray = Vector.empty[(Int, Int, Double)]
  (1 to n).foreach { _ =>
    val abInput = scala.io.StdIn.readLine()
    val ab = abInput.split(" ").map(_.toInt).toVector
    val efficiency = ab(1).toDouble / ab(0).toDouble
    val input = (ab(0), ab(1), efficiency)
    abArray :+= input
  }
  val abArraySorted = abArray.sortBy(_._3)

  var useMagic = (0, 0)
  def getUseMagical(h: Int):(Int, Int) = {
    abArraySorted.find(ab => h <= ab._1).fold {
      (abArraySorted(0)._1, abArraySorted(0)._2)
    }{ _ =>
      val min = abArraySorted.filter(ab => h <= ab._1).minBy(_._2)
      (min._1, min._2)
    }
  }

  var result = 0
  var tairyoku = h
  val b = new Breaks
  b.breakable {
    while(true) {
      useMagic = getUseMagical(tairyoku)
      val syou = tairyoku / useMagic._1
      val amari = tairyoku % useMagic._1
      if(syou == 0) {
        result = result + useMagic._2
        b.break()
      } else if (amari == 0){
        result = result + syou * useMagic._2
        b.break()
      } else {
        result = result + syou * useMagic._2
        tairyoku = amari
      }
    }
  }
  println(result)
}
