
class onetwoeight {

  object Solution {
    def longestConsecutive(nums: Array[Int]): Int = {

      val numSet = nums.toSet

      def seqLen(cur: Int): Int = {
        var count = 0
        while (numSet.contains(cur)) count = count + 1
        return count
      }

      numSet.foldRight(0) {
        case (cur, maxLen) =>
          if (!numSet.contains(cur - 1)) maxLen
          else math.max(seqLen(cur), maxLen)
      }
    }
  }


}
