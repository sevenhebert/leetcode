class twoonefive {

  object Solution {
    def findKthLargest(nums: Array[Int], k: Int): Int = {
      val ns = nums.sorted
      ns(nums.length - k)
    }
  }

}
