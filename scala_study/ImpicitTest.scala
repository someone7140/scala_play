package implicitTest




object PackageTest{
  def main() = {
    // 空クラスの作成
    val test = TestEmptyClass()
    // ①暗黙の引数メソッド
    implicit val param = 6
    println(returnInt2)
    // ②暗黙のメソッド
    println(4 + test)
    // ③暗黙のクラス
    test.plintTest

  }
  // テスト用の空クラス
  case class TestEmptyClass(){}
  
  // ①暗黙の引数メソッド
  def returnInt2(implicit param:Int):Int = {
     param + 5
  }
  
  // ②暗黙のメソッド
  implicit def returnInt(param:TestEmptyClass):Int = {
    3
  }
  
  // ③暗黙のクラス
  implicit class ImpClass(param:TestEmptyClass){
    def plintTest= {
      println("testclass")
    }
  }
}

