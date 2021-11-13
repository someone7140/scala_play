package beginnerContest211

object Cchokudai extends App {
  val s = scala.io.StdIn.readLine();
  val resultArray = Array.ofDim[Long](s.length + 1, 9)

  (0 to 8).foreach(index => {
    resultArray(0)(index) = 0
  })

  (0 to s.length).foreach(index => {
    resultArray(index)(0) = 1
  })

  (1 to s.length).foreach(index1 => {
    (1 to 8).foreach(index2 => {
      val sWord = s(index1 - 1).toString
      if (index2 == 1 && sWord == "c") {
        resultArray(index1)(index2) =
          (resultArray(index1 - 1)(index2 - 1) + resultArray(index1 - 1)(index2)) % 1000000007L
      } else if (index2 == 2 && sWord == "h") {
        resultArray(index1)(index2) =
          (resultArray(index1 - 1)(index2 - 1) + resultArray(index1 - 1)(index2)) % 1000000007L
      } else if (index2 == 3 && sWord == "o") {
        resultArray(index1)(index2) =
          (resultArray(index1 - 1)(index2 - 1) + resultArray(index1 - 1)(index2)) % 1000000007L
      } else if (index2 == 4 && sWord == "k") {
        resultArray(index1)(index2) =
          (resultArray(index1 - 1)(index2 - 1) + resultArray(index1 - 1)(index2)) % 1000000007L
      } else if (index2 == 5 && sWord == "u") {
        resultArray(index1)(index2) =
          (resultArray(index1 - 1)(index2 - 1) + resultArray(index1 - 1)(index2)) % 1000000007L
      } else if (index2 == 6 && sWord == "d") {
        resultArray(index1)(index2) =
          (resultArray(index1 - 1)(index2 - 1) + resultArray(index1 - 1)(index2)) % 1000000007L
      } else if (index2 == 7 && sWord == "a") {
        resultArray(index1)(index2) =
          (resultArray(index1 - 1)(index2 - 1) + resultArray(index1 - 1)(index2)) % 1000000007L
      } else if (index2 == 8 && sWord == "i") {
        resultArray(index1)(index2) =
          (resultArray(index1 - 1)(index2 - 1) + resultArray(index1 - 1)(index2)) % 1000000007L
      } else {
        resultArray(index1)(index2) = resultArray(index1 - 1)(index2)
      }
    })
  })

  println(resultArray(s.length)(8))

}
