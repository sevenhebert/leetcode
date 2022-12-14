class fiftyfour {

  object Solution {
    def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {

      var left = false
      var right = true
      var down = false
      var up = false
      val end = matrix.length * matrix.head.length

      def rec(i: Int, j: Int, res: List[Int]): List[Int] = {
        if (res.length == end) res
        else if (right) {
          if (j == matrix.head.length || matrix(i)(j) == 101) {
            right = false
            down = true
            rec(i + 1, j - 1, res)
          }
          else {
            val update = matrix(i)(j)
            matrix(i)(j) = 101
            rec(i, j + 1, res :+ update)
          }
        }
        else if (down) {
          if (i == matrix.length || matrix(i)(j) == 101) {
            down = false
            left = true
            rec(i - 1, j - 1, res)
          }
          else {
            val update = matrix(i)(j)
            matrix(i)(j) = 101
            rec(i + 1, j, res :+ update)
          }
        }
        else if (left) {
          if (j == -1 || matrix(i)(j) == 101) {
            left = false
            up = true
            rec(i - 1, j + 1, res)
          }
          else {
            val update = matrix(i)(j)
            matrix(i)(j) = 101
            rec(i, j - 1, res :+ update)
          }
        }
        else {
          if (i == -1 || matrix(i)(j) == 101) {
            up = false
            right = true
            rec(i + 1, j + 1, res)
          }
          else {
            val update = matrix(i)(j)
            matrix(i)(j) = 101
            rec(i - 1, j, res :+ update)
          }
        }
      }

      rec(0, 0, List.empty)
    }

  }
}
