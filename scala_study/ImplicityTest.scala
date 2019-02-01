package implicityTest


object ImplicityTest extends ParentImplicityTest{
  def main() = {
    // 直接変数を拾う
	println(test)
    // メソッドで暗黙の変数を拾う
    printlnImplicity
	// implicitlyで暗黙の変数を拾う
    println("val:" + implicitly[String])
  }
  def printlnImplicity(implicit param:String):Unit = {
    println("method:" + param)
  }
}

abstract class ParentImplicityTest {
  implicit val test:String = "implicitTest"
}
