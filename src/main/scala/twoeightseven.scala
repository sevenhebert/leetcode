class twoeightseven {

  object Solution {
    def findDuplicate(nums: Array[Int]): Int = {

      def findIntersection(slow: Int, fast: Int): Int =
        if (slow == fast) nums(slow)
        else findIntersection(nums(slow), nums(nums(fast)))

      def findCycle(slow: Int, slow2: Int): Int =
        if (slow == slow2) slow
        else findCycle(nums(slow), nums(slow2))

      findCycle(findIntersection(0, nums(0)), 0)
    }
  }

}
