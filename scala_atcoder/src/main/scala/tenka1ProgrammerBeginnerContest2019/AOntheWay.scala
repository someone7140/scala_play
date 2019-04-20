package tenka1ProgrammerBeginnerContest2019

// https://atcoder.jp/contests/tenka1-2019-beginner/tasks/tenka1_2019_a

object AOntheWay extends App {
  var input = scala.io.StdIn.readLine()
  val array = input.split(" ").map(_.toInt)

  if((array(0) <= array(2) && array(1) >= array(2)) || (array(1) <= array(2) && array(0) >= array(2))) {
    print("Yes")
  } else {
    print("No")
  }
}
