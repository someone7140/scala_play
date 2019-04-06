package beginnerContest123

// https://atcoder.jp/contests/abc123/tasks/abc123_a

object AFiveAntennas extends App {
  var array = Vector.empty[Int]
  var k = 0
  for(i<-1 to 6) {
    if (i == 6) {
      k = scala.io.StdIn.readInt()
    } else {
      array :+= scala.io.StdIn.readInt()
    }

  }
  val distance = array.max - array.min
  if (distance <= k) {
    println("Yay!")
  } else {
    println(":(")
  }

}