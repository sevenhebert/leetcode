class threenine {

  object Solution {

    import collection.mutable

    def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
      // sort and start from highest num
      // foreach number subtract from target and add self or next repeatedly
      // until remainder is zero->add to result, or negative->move to next or terminate
      val res = mutable.ListBuffer[List[Int]]()

      def rec(idx: Int, total: Int, cur: List[Int]): Unit =
        if (total == target) res.addOne(cur)
        else if (idx == candidates.length || total + candidates(idx) > target) ()
        else {
          rec(idx + 1, total + candidates(idx), cur)
          rec(idx, total + candidates(idx), cur :+ candidates(idx))
        }

      candidates.foreach(c => rec(0, 0, List.empty))
      res.toList
    }
  }

}
