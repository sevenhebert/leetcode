
class threefourseven {

  def topKFrequent(nums: Array[Int], k: Int): Array[Int] = {

    val count: Array[List[Int]] = Array.fill(nums.length + 1)(List.empty)

    val numsSorted = nums.sorted

    def getK(idx: Int, rem: Int, res: List[Int]): Array[Int] =
      if (rem == 0) res.toArray
      else getK(idx - 1, rem - count(idx).length, res.appendedAll(count(idx)))

    def rec(idx: Int, curNum: Int, curCount: Int): Array[Int] =
      if (idx == nums.length) {
        count(curCount) = count(curCount).appended(curNum)
        getK(nums.length, k, List.empty)
      }
      else if (numsSorted(idx) == curNum) rec(idx + 1, curNum, curCount + 1)
      else {
        count(curCount) = count(curCount).appended(curNum)
        rec(idx + 1, numsSorted(idx), 1)
      }

    rec(0, numsSorted.head, 0)
  }

}
