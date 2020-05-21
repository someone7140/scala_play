
import scala.util.control.Breaks

object CombinationsSample extends App {
  val target = scala.io.StdIn.readInt()
  val nums = Seq(2, 7, 11, 15)
  val b = new Breaks
  var result = Seq.empty[Int]

  b.breakable {
    (1 to nums.length).foreach { i =>
      nums.combinations(i).foreach { n =>
        if (target == n.sum) {
          result = n.map { n2 =>
            nums.indexOf(n2)
          }
          b.break()
        }
      }
    }
  }
  println(result)
}
