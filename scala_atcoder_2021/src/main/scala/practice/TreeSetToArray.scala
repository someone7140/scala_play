package practice

import scala.collection.immutable.TreeSet

object TreeSetToArray extends App {
  // 降順に設定する
  val ordering = Ordering[Int].reverse
  val sampleTreeSet = TreeSet(3, 4, 1, 2)(ordering)
  // 4, 3, 2, 1の順になる
  println(sampleTreeSet)

  // 配列に変換
  val sampleArray = sampleTreeSet.toArray
  // index1を指定した場合は「3」が返る
  println(sampleArray(1))

}
