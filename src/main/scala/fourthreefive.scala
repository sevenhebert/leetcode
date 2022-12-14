import jdk.javadoc.internal.tool.Start

class fourthreefive {

  object Solution {
    def eraseOverlapIntervals(intervals: Array[Array[Int]]): Int = {

      val is = intervals.sortBy(i => (i.head, i.last))

      def rec(i: Int, prevEnd: Int, res: Int): Int =
        if (i == is.length) res
        else if (is(i).head < prevEnd) rec(i + 1, math.min(prevEnd, is(i).last), res + 1)
        else rec(i + 1, is(i).last, res)

      rec(0, is(0).head, 0)
    }
  }

}
