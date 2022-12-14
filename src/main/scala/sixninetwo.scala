class sixninetwo {

  object Solution {
    def topKFrequent(words: Array[String], k: Int): List[String] = {

      import collection.mutable

      val counts = mutable.Map[String, Int]()

      def read(i: Int): Unit =
        if (i < words.length) {
          counts.updateWith(words(i)) {
            case Some(prev) => Some(prev + 1)
            case None => Some(1)
          }
          read(i + 1)
        }

      read(0)

      val sorted = counts.toList.sortBy(x => (x._2, x._1)).reverse

      def rec(xs: List[(String, Int)], res: List[String]): List[String]  =
        if (res.length - 1 == k) res
        else rec(xs.tail, xs.head._1 +: res)

      rec(sorted, List.empty)
    }
  }

}
