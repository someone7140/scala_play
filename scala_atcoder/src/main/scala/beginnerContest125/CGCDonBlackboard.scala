package beginnerContest125

// https://atcoder.jp/contests/abc125/tasks/abc125_c

object CGCDonBlackboard extends App {
  val n = scala.io.StdIn.readInt()
  var aInput = scala.io.StdIn.readLine()
  val aArray =  aInput.split(" ").map(_.toInt).toVector
  var max = 0
  def getGcd(aInput: Int, bInput: Int): Int = {
    var tmp = 0
    var aInit = 0
    var bInit = 0
    if(aInput > bInput) {
      aInit = bInput
      bInit = aInput
    } else {
      aInit = aInput
      bInit = bInput
    }
    var a = aInit
    var b = bInit
    // println(s"------------${aInput}:${bInput}----------------")
    while ( {
      tmp = a % b
      // println(tmp)
      tmp != 0
    }) {
      a = b
      b = tmp
    }
    if(b == bInit) {
      1
    } else {
      b
    }
  }
  if(n == 2) {
    max = if (aArray(0) > aArray(1)) aArray(0) else aArray(1)
  } else {
    val lastIndex = aArray.length - 1
    // 最初を起点にした最大公約数リスト
    val list1 = aArray.tail.map(a => getGcd(aArray(0), a)).sorted
    // 最後を起点とした最大公約数リスト
    val list2 = aArray.init.map(a => getGcd(aArray(lastIndex), a)).sorted
    // println(list1)
    // println(list2)
    // 最小から二つ目の大きい方
    var maxList = Vector.empty[Int]
    if (list1(1) > list2(1)) {
      maxList = list1.tail
    } else {
      maxList = list2.tail
    }
    if(maxList.length > 1) {
      max = getGcd(maxList(0), maxList(1))
    } else {
      max = maxList(0)
    }

  }
  print(max)
}
