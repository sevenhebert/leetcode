class twozeroseven {

  object Solution {

    import collection.mutable

    def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {

      val visited = mutable.Set[Int]()
      val preReqs = mutable.Map[Int, Array[Int]]()
      (0 to numCourses).foreach(preReqs.addOne(_, Array.empty))
      prerequisites.foreach(pr => preReqs.updateWith(pr.head) {
        case Some(value) => Some(value :++ pr.tail)
        case None => Some(pr.tail)
      })

      def dfs(crs: Int): Boolean =
        if (visited.contains(crs)) false
        else if (preReqs(crs).isEmpty) true
        else {
          visited.addOne(crs)
          val res = preReqs(crs).forall(dfs)
          visited.remove(crs)
          preReqs.update(crs, Array.empty)
          res
        }


      (0 to numCourses).forall(dfs)
    }
  }

}