package beginnerContest116

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
    seqTd :+= (tdInt(0), tdInt(1))
  }
  seqTd = seqTd.sortBy(_._2).reverse
  var maxSeq = Seq.empty[(Int, Int)]

  for(i<-0 to k - 1){
    // 最大値のリストを取得
    val maxValueSeq = seqTd.filter(_._2 == seqTd(0)._2)
    // 種類が違うのがあるか
    val maxVariableAndValue = maxValueSeq.find(m =>
      maxSeq.filter(_._1 == m._1).isEmpty
    )
    maxVariableAndValue match {
      case Some(m) =>
        maxSeq :+= m
        seqTd = seqTd.filterNot(s=> s._1 == m._1 && s._2 == m._2)
      case _ =>
        // 種類が違うのがあるか
        seqTd.find(s=> maxSeq.find(m=> s._1 != m._1).isDefined) match {
          case Some(v) =>
            val variableCount = maxSeq.map(_._1).distinct.size
            val nextVariableCount = variableCount + 1
            if ( (nextVariableCount * nextVariableCount - variableCount * variableCount) >= seqTd(0)._2 ) {
              maxSeq :+= v
              seqTd = seqTd.filterNot(s=> s._1 == v._1 && s._2 == v._2)
            } else {
              maxSeq :+= seqTd(0)
              seqTd = seqTd.filterNot(s=> s._1 == seqTd(0)._1 && s._2 == seqTd(0)._2)
            }
          case _ =>
            maxSeq :+= seqTd(0)
            seqTd = seqTd.filterNot(s=> s._1 == seqTd(0)._1 && s._2 == seqTd(0)._2)
        }
    }
  }
  println(calculatePoint(maxSeq))
}