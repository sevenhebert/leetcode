class sevenzerofour {

  object Solution {
    def search(nums: Array[Int], target: Int): Int = {

      def rec(i: Int, j: Int): Int = {
        val mid = ((j - i) / 2) + i
        if (target == nums(i)) i
        else if (target == nums(j)) j
        else if (target < nums(i) || target > nums(j) || j - i == 1) -1
        else if (target <= nums(mid)) rec(i, mid)
        else rec(mid, j)
      }

      rec(0, nums.length - 1)
    }
  }

}
