class sevenfour {

  object Solution {

    def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {

      def search(i: Int, j: Int): Boolean = {
        val mid = ((j - i) / 2) + i
        if (target < matrix(i).head || target > matrix(j).last) false
        else if (i == mid) matrix(i).contains(target) || matrix(j).contains(target)
        else if (target <= matrix(mid).head) search(i, mid)
        else search(mid, j)
      }

      search(0, matrix.length - 1)
    }
  }

}
