package diverta2019ProgrammingContest

// https://atcoder.jp/contests/diverta2019/tasks/diverta2019_c

object CABSubstrings extends App {
  val n = scala.io.StdIn.readInt()
  var array = Vector.empty[String]
  for(i<-1 to n) {
    array :+= scala.io.StdIn.readLine()
  }
  var editedArray = array
  var sentence = ""
  for(i<-1 to n) {
    if(i % 2 == 1) {
      val a1 = editedArray.find(e => e.endsWith("A") && !e.startsWith("B"))
      if(a1.isDefined) {
        sentence = sentence + a1.get
        editedArray = editedArray.diff(Seq(a1.get))
      } else {
        val a2 = editedArray.find(e => e.endsWith("A"))
        if (a2.isDefined) {
          sentence = sentence + a2.get
          editedArray = editedArray.diff(Seq(a2.get))
        } else {
          val a3 = editedArray(0)
          sentence = sentence + a3
          editedArray = editedArray.diff(Seq(a3))
        }
      }
    } else {
      val b1 = editedArray.find(e => !e.endsWith("A") && e.startsWith("B"))
      if(b1.isDefined) {
        sentence = sentence + b1.get
        editedArray = editedArray.diff(Seq(b1.get))
      } else {
        val b2 = editedArray.find(e => e.startsWith("B"))
        if (b2.isDefined) {
          sentence = sentence + b2.get
          editedArray = editedArray.diff(Seq(b2.get))
        } else {
          val a3 = editedArray(0)
          sentence = sentence + a3
          editedArray = editedArray.diff(Seq(a3))
        }
      }
    }
  }
  val count = (sentence.length - sentence.replace("AB", "").length) / 2
  println(count)
}
