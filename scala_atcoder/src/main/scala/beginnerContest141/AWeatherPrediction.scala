package beginnerContest141

// https://atcoder.jp/contests/abc141/tasks/abc141_b

object AWeatherPrediction extends App {
  val s =  scala.io.StdIn.readLine()
  if(s == "Sunny") {
    println("Cloudy")
  } else if(s == "Rainy") {
    println("Sunny")
  } else {
    println("Rainy")
  }
}
