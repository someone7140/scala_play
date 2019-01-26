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
  var maxSeq = Seq.empty[(Int, Int)]
  
  // まずは最大値ポイントでリストを作成
  for(i<-0 to k - 1){
    maxSeq = seqTd(0) +: maxSeq
    seqTd =  seqTd.tail
  }
  var maxPoint = calculatePoint(maxSeq)
  
  // 種類が違うリストを作る。
  val differenceKindSeq = seqTd.filter(s =>
    maxSeq.find(_._1 == s._1).isEmpty
  )
  differenceKindSeq.sortBy(_._2).reverse
  
  val b = new Breaks

  b.breakable{
    differenceKindSeq.foreach { ds =>
      // 同種類が2レコード以上の種類リスト
      val duplicateKindKeyMap = maxSeq.groupBy(_._1)
      val duplicateKindKeySeq = duplicateKindKeyMap.filter(_._2.size > 1).map(_._2).flatten.toSeq.sortBy(_._2)
      if (duplicateKindKeySeq.isEmpty) {
        b.break()
      } else {
        // 違う種類の中で最大ポイント
        val differentKindSeq = seqTd.filter(f=> duplicateKindKeySeq.exists(_._1 != f._1)).sortBy(_._2).reverse
        if (differentKindSeq.isEmpty) {
          b.break()
        } else {
          // 最小ポイントを除く
          var maxSeqTemp = maxSeq.filterNot(s => s._1 == duplicateKindKeySeq(0)._1 && s._2 == duplicateKindKeySeq(0)._2)
          // 最大ポイントをたす
          maxSeqTemp = differentKindSeq(0) +: maxSeqTemp
          val pointTemp = calculatePoint(maxSeqTemp)
          if(maxPoint < pointTemp) {
            maxPoint = pointTemp
            maxSeq = maxSeqTemp
            seqTd = seqTd.filterNot(s => s._1 == differentKindSeq(0)._1 && s._2 == differentKindSeq(0)._2)
          }
        }
      }
    }
  }
  println(maxPoint)
  
}