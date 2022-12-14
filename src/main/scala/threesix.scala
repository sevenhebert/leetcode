class threesix {

  object Solution {
    def isValidSudoku(board: Array[Array[Char]]): Boolean = {

      def valid(row: Seq[Char]): Boolean = {
        val numbers = row.filterNot(_ == '.')
        numbers.distinct == numbers
      }

      val cols = (0 to 8).forall(c => valid((0 to 8).map(r => board(r)(c))))
      lazy val rows = board.forall(r => valid(r.toSeq))
      lazy val sqrs = List((0, 0), (0, 3), (0, 6), (3, 0), (3, 3), (3, 6), (6, 0), (6, 3), (6, 6))
        .forall { case (r, c) => valid((c to c + 2).flatMap(c => (r to r + 2).map(r => board(r)(c)))) }

       cols && rows && sqrs
    }
  }

}
