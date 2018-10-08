object ApplyTest{
  def main() = {
    // オブジェクトをnewする。
    var nonApplyTest = new NonApplyTest("test1" , "test2")
    // 引数の変数名から直接値を取得する。
    println(nonApplyTest.test1input + nonApplyTest.test2input)
    
    // ここでapplyが呼ばれる。
    val applyTestWithCase = ApplyTestWithCase("test1" , "test2")
    applyTestWithCase match{
      // ここでunapplyが呼ばれる
      case ApplyTestWithCase(s1 , s2) => println(s1 + s2)
      case _ => println("None")
    }

  }

}

// 引数を取得するためコンストラクタにvalを設定する。
class NonApplyTest(val test1input:String ,  val test2input:String){

}

// unapplyがあるのでコンストラクタにvalは不要。
case class ApplyTestWithCase(test1input:String , test2input:String){

}
