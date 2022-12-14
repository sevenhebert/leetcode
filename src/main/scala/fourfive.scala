class fourfive {

  object Solution {

    def jump(nums: Array[Int]): Int = {

      def furthest(i: Int, j: Int, max: Int): Int =
        if (i == j) math.max(max, i + nums(i))
        else furthest(i + 1, j, math.max(max, i + nums(i)))

      def rec(l: Int, r: Int, jumps: Int): Int =
        if (r >= nums.length) jumps
        else {
          val rNext = furthest(l, r, 0)
          rec(r + 1, rNext, jumps + 1)
        }

      rec(0, nums(0), 0)
    }


  }

}
