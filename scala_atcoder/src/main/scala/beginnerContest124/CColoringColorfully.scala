package beginnerContest124

// https://atcoder.jp/contests/abc124/tasks/abc124_c

object CColoringColorfully extends App {
  var s = scala.io.StdIn.readLine()
  val sArray = s.map(_.toString.toInt).toVector
  val length = sArray.length
  var array1 = Vector.empty[Int]
  var array2 = Vector.empty[Int]
  for (i <- 1 to (length)) {
    val twoExtra = i % 2
    array1 :+= twoExtra
    if (twoExtra == 0) {
      array2 :+= 1
    } else {
      array2 :+= 0
    }
  }
  var diffCount1 = sArray.zipWithIndex.map { case(s, index) =>
    if(s == array1(index)) {
      0
    } else {
      1
    }
  }.sum
  val diffCount2 = sArray.zipWithIndex.map { case(s, index) =>
    if(s == array2(index)) {
      0
    } else {
      1
    }
  }.sum
  if(diffCount1 >= diffCount2) {
    print(diffCount2)
  } else {
    print(diffCount1)
  }
}
