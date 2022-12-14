class fivefive {

  object Solution {

    def canJump(nums: Array[Int]): Boolean = {

      def rec(idx: Int, goalIdx: Int): Boolean =
        if (goalIdx == 0) true
        else if (nums(idx) > 0 && nums(idx) + idx >= goalIdx) rec(idx - 1, idx)
        else if (nums(idx) == 0 && idx != 0) rec(idx - 1, goalIdx)
        else false

      rec(nums.length - 1, nums.length - 1)
    }

  }

}

//[5,9,3,2,1,0,2,3,3,1,0,0]
//[3,2,1,0,4]
//[0]
//[2,5,0,0]
//[0,1]
//[1,2,3]