

object SplitAt extends App {
  val str1 = "あいうえおあいうえおあいうえおあいうえおあいうえお"
  val str1Split = str1.splitAt(22)
  println(str1Split)

  val str2 = "あいうえお"
  println(str2.splitAt(22))

  val str3="abcdeabcdeabcdeabcdeabcde"
  println(str3.splitAt(22))

}
