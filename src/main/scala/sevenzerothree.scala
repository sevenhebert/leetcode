class sevenzerothree {

  class KthLargest(_k: Int, _nums: Array[Int]) {

    import collection.mutable

    private val pq = mutable.PriorityQueue(_nums: _*)(Ordering[Int].reverse)

    def add(`val`: Int): Int = {
      pq.enqueue(`val`)
      if (pq.size >= _k) pq.dequeue
      pq.head
    }

  }


}
