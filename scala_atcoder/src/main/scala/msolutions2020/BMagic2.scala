package msolutions2020

// https://atcoder.jp/contests/m-solutions2020/tasks/m_solutions2020_b

import scala.util.control.Breaks

object BMagic2 extends App {
  val abcInput = scala.io.StdIn.readLine()
  val abcArray =  abcInput.split(" ").map(_.toInt).toVector
  var a = abcArray(0)
  var b = abcArray(1)
  var c = abcArray(2)

  val k =  scala.io.StdIn.readInt()

  val br = new Breaks

  var count = 0
  var successFlg = false

  br.breakable {
    while(true) {
      if (count > k) {
        br.break()
      } else if (a < b && b < c) {
        successFlg = true
        br.break()
      } else {
        if(a >= b) {
          b = b * 2
        } else {
          c = c * 2
        }
        count = count + 1
      }
    }
  }

  if (successFlg) {
    println("Yes")
  } else {
    println("No")
  }

}
