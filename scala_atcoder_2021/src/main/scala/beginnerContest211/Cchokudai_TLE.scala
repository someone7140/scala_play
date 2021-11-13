package beginnerContest211

object Cchokudai_TLE extends App {
  val s = scala.io.StdIn.readLine();
  var result = 0L

  def calc(input: String, extract: String): Unit = {
    var tempInput = input
    if (extract.length == 8) {
      if (extract == "chokudai") {
        result = (result + 1L) % 1000000007L
      }
    } else if (input.length > 0) {
      if (extract.length == 0) {
        val cIndex = tempInput.indexOf('c')
        if (cIndex > -1) {
          tempInput = input.substring(cIndex, input.length)
          calc(tempInput.tail, extract + "c")
          calc(tempInput.tail, extract)
        }
      } else if (extract.length == 1) {
        val cIndex = tempInput.indexOf('h')
        if (cIndex > -1) {
          tempInput = input.substring(cIndex, input.length)
          calc(tempInput.tail, extract + "h")
          calc(tempInput.tail, extract)
        }
      } else if (extract.length == 2) {
        val cIndex = tempInput.indexOf('o')
        if (cIndex > -1) {
          tempInput = input.substring(cIndex, input.length)
          calc(tempInput.tail, extract + "o")
          calc(tempInput.tail, extract)
        }
      } else if (extract.length == 3) {
        val cIndex = tempInput.indexOf('k')
        if (cIndex > -1) {
          tempInput = input.substring(cIndex, input.length)
          calc(tempInput.tail, extract + "k")
          calc(tempInput.tail, extract)
        }
      } else if (extract.length == 4) {
        val cIndex = tempInput.indexOf('u')
        if (cIndex > -1) {
          tempInput = input.substring(cIndex, input.length)
          calc(tempInput.tail, extract + "u")
          calc(tempInput.tail, extract)
        }
      } else if (extract.length == 5) {
        val cIndex = tempInput.indexOf('d')
        if (cIndex > -1) {
          tempInput = input.substring(cIndex, input.length)
          calc(tempInput.tail, extract + "d")
          calc(tempInput.tail, extract)
        }
      } else if (extract.length == 6) {
        val cIndex = tempInput.indexOf('a')
        if (cIndex > -1) {
          tempInput = input.substring(cIndex, input.length)
          calc(tempInput.tail, extract + "a")
          calc(tempInput.tail, extract)
        }
      } else if (extract.length == 7) {
        val cIndex = tempInput.indexOf('i')
        if (cIndex > -1) {
          tempInput = input.substring(cIndex, input.length)
          calc(tempInput.tail, extract + "i")
          calc(tempInput.tail, extract)
        }
      }
    }
  }

  calc(s, "")
  println(result)

}
