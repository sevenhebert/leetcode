class onezerofoursix {

  object Solution {

    import collection.mutable

    def lastStoneWeight(stones: Array[Int]): Int = {
      val pq = mutable.PriorityQueue(stones: _*)

      def rec: Int =
        if (pq.isEmpty) 0
        else if (pq.size == 1) pq.dequeue
        else {
          val rem = pq.dequeue - pq.dequeue
          if (rem > 0) pq.enqueue(rem)
          rec
        }

      rec
    }

  }

}

