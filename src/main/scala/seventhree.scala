class seventhree {

  object Solution {
    def setZeroes(matrix: Array[Array[Int]]): Unit = {

      val seen = scala.collection.mutable.Set.empty[(Int, Int)]
      def maybeSetZeros(row: Int, col: Int): Unit =
        if (matrix(row)(col) != 0) ()
        else {
          matrix.head.indices.collect { case ci if matrix(row)(ci) != 0 =>
            matrix(row)(ci) = 0
            seen.add(row, ci)
          }
          matrix.indices.collect { case ri if matrix(ri)(col) != 0 =>
            matrix(ri)(col) = 0
            seen.add(ri, col)
          }
        }


      def rec(row: Int, col: Int): Array[Array[Int]] =
        if (row == matrix.length - 1 && col == matrix.head.length) matrix
        else if (col == matrix.head.length) rec(row + 1, 0)
        else if (seen.contains(row, col)) rec(row, col + 1)
        else {
          maybeSetZeros(row, col)
          rec(row, col + 1)
        }

      rec(0, 0)
    }
  }

}
