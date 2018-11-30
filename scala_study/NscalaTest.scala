import com.github.nscala_time.time.Imports._

object NscalaTest{
  def main() = {
    // ①現在時刻
    println(DateTime.now)
    // ②hour以降を切り捨て
    println(DateTime.now.day.roundFloor)
    // ③minute以降を切り捨て
    println(DateTime.now.hour.roundFloor)
  }

}

