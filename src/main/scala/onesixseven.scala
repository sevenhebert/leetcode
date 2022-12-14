class onesixseven {


  def twoSum(numbers: Array[Int], target: Int): Array[Int] = {

    def rec(i: Int, j: Int): Array[Int] =
      if (numbers(i) + numbers(j) == target) Array(i + 1, j + 1)
      else if (numbers(i) + numbers(j) > target) rec(i, j - 1)
      else rec(i + 1, j)

    rec(0, numbers.length - 1)
  }

}
