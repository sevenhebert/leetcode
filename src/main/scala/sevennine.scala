class sevennine {

  object Solution {

    import collection.mutable

    def exist(board: Array[Array[Char]], word: String): Boolean = {

      val visited = mutable.Set[(Int, Int)]()

      def dfs(target: String, r: Int, c: Int): Boolean =
        if (board(r)(c) != target.head) false
        else if (target.isEmpty || (board(r)(c) == target.head && target.tail.isEmpty)) true
        else {
          visited.addOne((r, c))
          val res = List((r - 1, c), (r, c + 1), (r + 1, c), (r, c - 1))
            .g { case (nr, nc) if board.indices.contains(nr) && board.head.indices.contains(nc) && !visited.contains((nr, nc)) =>
              dfs(target.tail, nr, nc)
            }.nonEmpty
          visited.remove((r, c))
          res
        }

      def rec(r: Int, c: Int): Boolean =
        if (r == board.length) false
        else if (c == board.head.length) rec(r + 1, 0)
        else dfs(word, r, c) || rec(r, c + 1)

      rec(0, 0)
    }
  }


}
