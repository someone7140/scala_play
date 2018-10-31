object FactoryTest{
  def main() = {
    // 埼玉県のインスタンス
    val  todoufukenTest1 = FactoryObject.getInstance("saitama")
    println(todoufukenTest1.getName())
    
    // 神奈川県のインスタンス
    val  todoufukenTest2 = FactoryObject.getInstance("kanagawa")
    println(todoufukenTest2.getName())

  }

}

// インスタンスを取得するFactoryオブジェクト
object FactoryObject {
  // インスタンスを取得
  def getInstance(indicator: String):Todoufuken = {
    getTodoufukenOpt(indicator) match {
      case Some(todoufuken) => todoufuken
      case _ => null
    }
  }
  
  // 都道府県のリストから識別子でインスタンスを取得
  def getTodoufukenOpt(indicator:String):Option[Todoufuken] = {
    todoufukenList.find(_.indicator == indicator)
  }
  
  val todoufukenList = List(Saitamaken(), Kanagawaken())
  
  // 都道府県の抽象クラス
  abstract class Todoufuken{
    val indicator: String
    def getName(): String
  }
  
  case class Saitamaken() extends Todoufuken {
    val indicator ="saitama"
    def getName(): String = {
      "埼玉県"
    }
  }
  
  case class Kanagawaken() extends Todoufuken {
    val indicator ="kanagawa"
    def getName(): String = {
      "神奈川県"
    }
  }

}

