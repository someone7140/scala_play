
object LazyTest{
  def main() = {
    val judgeOpt = Some(11)
    testAfter(judgeOpt)
  }
  
  def testBefore(judgeOpt: Option[Int]) = {
    val numberList = Seq(1,2,3,4,5,6,7,8,9,10)

    val (leftList,rightList) = numberList.partition{ n =>
      if (judgeOpt.isEmpty) {
        false
      } else if (judgeOpt.get > numberList.length) {
        true
      } else {
        if (n % judgeOpt.get == 0) {
          false
        } else {
          true
        }
      }
    }
    println(leftList)
  }
  
  def testAfter(judgeOpt: Option[Int]) = {
    val numberList = Seq(1,2,3,4,5,6,7,8,9,10)
    def judgeFunction(judgeOpt: Option[Int], list: Seq[Int]):(Int) => Boolean = {
      if (judgeOpt.isEmpty) {
        println("None")
        (_: Int) => false
      } else if (judgeOpt.get > list.length) {
        println("Over")
        (_: Int) => true
      } else {
        divideFuncton(_: Int, judgeOpt.get)
      }
    }
    def divideFuncton(target: Int, input: Int):Boolean = {
      if (target % input == 0) {
        false
      } else {
        true
      }
    }
    
    lazy val f = judgeFunction(judgeOpt, numberList)
    val (leftList,rightList) = numberList.partition{ n =>
      f(n)
    }
    println(leftList)
  }

}

object LazyExplain{
  def main() = {
    var test1 = 1
    var test2 = 2
    lazy val lazyTestSum = test1 + test2

    test1 = 3
    // この時点で評価
    println(s"lazyTestSum:${lazyTestSum}")

    test1 = 5
    // 一度評価されたら変わらない
    println(s"lazyTestSum:${lazyTestSum}")

  }
}
