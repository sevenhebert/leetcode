class nineseventhree {

  object Solution {

    import collection.mutable

    def kClosest(points: Array[Array[Int]], k: Int): Array[Array[Int]] = {

      val pq = mutable.PriorityQueue[(Double, Array[Int])]()(Ordering.by[(Double, Array[Int]), Double](_._1))

      def rec(i: Int): Array[Array[Int]] =
        if (i == points.length) pq.toArray.map(_._2)
        else {
          val x = points(i)(0)
          val y = points(i)(1)
          val dist = math.sqrt(x * x + y * y)
          pq.enqueue((dist, Array(x, y)))
          if (pq.size > k) pq.dequeue
          rec(i + 1)
        }

      rec(0)
    }

  }

}
