package hitachi2020

// https://atcoder.jp/contests/hitachi2020/tasks/hitachi2020_b

object BNiceShopping extends App {
  val abmInput  = scala.io.StdIn.readLine()
  val abmArray = abmInput.split(" ").map(_.toInt).toSeq
  val aLength = abmArray(0)
  val bLength = abmArray(1)
  val mLength = abmArray(2)

  val aInput = scala.io.StdIn.readLine()
  val aArray = aInput.split(" ").map(_.toInt).toVector
  val bInput = scala.io.StdIn.readLine()
  val bArray = bInput.split(" ").map(_.toInt).toVector

  var mMap = scala.collection.mutable.Map.empty[(Int, Int), Int]
  (1 to mLength).foreach { _ =>
    val mInput  = scala.io.StdIn.readLine()
    val mInputArray = mInput.split(" ").map(_.toInt).toSeq
    val key = (mInputArray(0), mInputArray(1))
    if (mMap.contains(key)) {
      val existingValue = mMap.get(key).get
      if(existingValue < mInputArray(2)) {
        mMap.put(key, mInputArray(2))
      }
    } else {
      mMap.put(key, mInputArray(2))
    }
  }

  var min = aArray.min + bArray.min
  mMap.keys.foreach { key =>
    val mCalculate = aArray(key._1 - 1) + bArray(key._2 - 1) - mMap.get(key).get
    if(mCalculate < min) {
      min = mCalculate
    }
  }
  println(min)
}
