package beginnerContest116

import scala.util.control.Breaks

// https://atcoder.jp/contests/abc116/tasks/abc116_d
object DVariousSushi extends App {
  var nk = scala.io.StdIn.readLine()
  var nkInt =  nk.split(" ").map(_.toInt)
  val n = nkInt(0)
  val k = nkInt(1)
  var seqTd = Seq.empty[(Int, Int)]

  def calculatePoint(s: Seq[(Int, Int)]): Long = {
    val variableCount = s.map(_._1).distinct.size
    val variablePoint:Long = variableCount * variableCount
    variablePoint + s.map(_._2).sum
  }

  for(i<-0 to n -1){
    val td = scala.io.StdIn.readLine()
    val tdInt =  td.split(" ").map(_.toInt)
    seqTd = (tdInt(0), tdInt(1)) +: seqTd
  }
  // ポイントでソート
  seqTd = seqTd.sortBy(_._2).reverse
  var maxSeq = Seq.empty[(Int, Int)]]
  
  // まずは最大値ポイントでリストを作成
  for(i<-0 to k - 1){
    maxSeq = m +: seqTd(0)
    seqTd =  seqTd.tail
  }
  var maxPoint = calculatePoint(maxSeq)
  
  // 種類が違うリストを作る。
  differenceKindSeq = seqTd.filter(s =>
    maxSeq.find(_._1 == s._1).isEmpty
  )
  differenceKindSeq.sortBy(_._2).reverse
  
  val b = new Breaks
  
  differenceKindSeq.foreach { ds =>
    // 同種類が2レコード以上の種類リスト
    val duplicateKindKeySeq = maxSeq.groupBy(_._1).map(dm =>
      
    
    )
    // そのなかで最小ポイント
    val lowestPoint = maxSeq.filter{ m =>
      duplicateKindKeySeq.exists(m._1)
    }.sortBy(_._2)(0)
    // 
  
  }
  println(calculatePoint(maxSeq))
  
}