import scala.annotation.tailrec
import scala.collection.mutable

class fouroneseven {

  object Solution {
    def pacificAtlantic(heights: Array[Array[Int]]): List[List[Int]] = {

      def search(q: List[(Int, Int)], res: Set[(Int, Int)]): Set[(Int, Int)] = q match {
        case Nil => res
        case ::((r, c), tail) =>
          val nbrs = List((r - 1, c), (r, c + 1), (r + 1, c), (r, c - 1))
          val update = nbrs.collect { case (nr, nc) if heights.indices.contains(nr) && heights.head.indices.contains(nc) && heights(nr)(nc) >= heights(r)(c) && !res.contains((nr, nc)) =>
            (nr, nc)
          }
          val qUpdate = tail :++ update
          val resUpdate = res ++ update
          search(qUpdate, resUpdate)
      }


      val north = heights.head.indices.map((0, _))
      val west = heights.indices.map((_, 0))
      val pacific = (north :++ west).toList
      val isPacific = search(pacific, pacific.toSet)

      val south = heights.head.indices.map((heights.length - 1, _))
      val east = heights.indices.map((_, heights.head.length - 1))
      val atlantic = (south :++ east).toList
      val isAtlantic = search(atlantic, atlantic.toSet)

      isPacific.intersect(isAtlantic).toList.map { case (x, y) => List(x, y) }
    }

  }

}
