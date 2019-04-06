package beginnerContest123

// https://atcoder.jp/contests/abc123/tasks/abc123_c

object CFiveTransportations extends App {
  var array = Vector.empty[Long]
  var n = 0L
  for(i<-1 to 6) {
    if (i == 1) {
      n = scala.io.StdIn.readLong()
    } else {
      array :+= scala.io.StdIn.readLong()
    }

  }
  var sum = 4L
  val timeTurple = array.zipWithIndex.map { case(a, index) =>
    val time =
      if (n / a == 0) 1
      else if (n % a == 0) n / a
      else (n / a) + 1
    (a, time, index)
  }
  val max = timeTurple.find(_._2 == timeTurple.map(_._2).max).get
  sum = sum + max._2
  println(sum)
}
