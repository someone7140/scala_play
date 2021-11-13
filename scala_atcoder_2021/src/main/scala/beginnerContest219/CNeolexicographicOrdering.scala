package beginnerContest219

object CNeolexicographicOrdering extends App {
  val x = scala.io.StdIn.readLine()
  val xMap = scala.collection.mutable.Map.empty[String, String]
  x.zipWithIndex.foreach(c => {
    val word = c._1.toString
    val indexAlphabet = (c._2 + 97).toChar.toString
    xMap.put(word, indexAlphabet)
  })

  val n = scala.io.StdIn.readInt()

  var resultVec = Vector.empty[(String, String)]
  (1 to n).foreach(_ => {
    val s = scala.io.StdIn.readLine()
    val indexStr = s.map(sChar => {
      xMap.get(sChar.toString).getOrElse("zzzzzz")
    }).mkString("")
    resultVec :+= (indexStr, s)
  })
  resultVec.sortBy(_._1)foreach(r => {
    System.out.println(r._2)
  })

}
