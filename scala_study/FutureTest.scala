import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.concurrent.duration._

object FutureTest {

  def main() = {
    testRecover(2)
  }
  def testRecover(param: Int) = {
    val sample1 = Future {
      if (param == 1) { 1 } else { throw new IllegalArgumentException("error!")}
    }
    val test = Await.result(
      sample1.map{f => Right(f * 2)}
        recover {case e: IllegalArgumentException => Left(e.getMessage)}
      , 1 minute)
    println(test)
  }

}
