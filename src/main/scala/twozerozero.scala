class twozerozero {

  object Solution {
    def numIslands(grid: Array[Array[Char]]): Int = {

      def search(q: List[(Int, Int)], visit: Set[(Int, Int)]): Set[(Int, Int)] = q match {
        case Nil => visit
        case ::((r, c), tail) =>
          val nbrs = Set((r - 1, c), (r, c + 1), (r + 1, c), (r, c - 1))
            .collect { case (nr, nc) if grid.indices.contains(nr) && grid.head.indices.contains(nc) && grid(nr)(nc) == '1' && !visit.contains((nr, nc)) => (nr, nc) }
          search(tail ++ nbrs, visit + ((r, c)) ++ nbrs)
      }


      def rec(r: Int, c: Int, count: Int, visit: Set[(Int, Int)]): Int =
        if (r == grid.length) count
        else if (c >= grid.head.length) rec(r + 1, 0, count, visit)
        else if (grid(r)(c) == '0' || visit.contains((r, c))) rec(r, c + 1, count, visit)
        else rec(r, c + 1, count + 1, search(List((r, c)), visit))

      rec(0, 0, 0, Set.empty)
    }

  }

}