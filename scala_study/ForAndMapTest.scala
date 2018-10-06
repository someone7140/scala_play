object ForAndMapTest{
  def main(){
    // OptionのListを用意
    val optionList = List[Option[Int]](Some(1) ,Some(2) ,Some(3) ,Some(4))
    
    // mapを使って1足したものを出力
    println(usingMapPlusOne(optionList))
    // foreachを使って1足したものを出力
    usingForaeachPlusOne(optionList)
    // flatmapを使って1足したものを出力
    println(usingFlatMapPlusOne(optionList))
    // for式を使って1足したものを出力
    println(usingForPlusOne(optionList))
    // flattenを使ってそのまま出力
    println(usingFlatten(optionList))

  }
  
  // mapで展開
  def usingMapPlusOne(optionList:List[Option[Int]]):List[Option[Int]] = {
    optionList.map(_.map(_ + 1))
  }
  
  // foreachで展開
  def usingForaeachPlusOne(optionList:List[Option[Int]]):Unit = {
    // 出力用に1プラスしてprint
    def printPlusOne(num:Int):Unit = println(num + 1)
    optionList.foreach(_.foreach( printPlusOne(_) ) ) 
  }
  
  // flatmapで展開
  def usingFlatMapPlusOne(optionList:List[Option[Int]]):List[Int] = {
    // 出力用に1プラス
    def plusOne(num:Int):Option[Int] = Some(num + 1)
    optionList.flatMap( _.flatMap( plusOne(_) ) )
  }

  // for式で展開
  def usingForPlusOne(optionList:List[Option[Int]]):List[Int] = {
    for{
      numberOption <- optionList
      number <- numberOption
    
    } yield{
      number + 1
    }
  }
  
  // flattenで展開
  def usingFlatten(optionList:List[Option[Int]]):List[Int] = {
    optionList.flatten
  }
  

  
  
}