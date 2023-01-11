class sixtwoone {

  object Solution {

    import collection.mutable

    val heap = mutable.PriorityQueue[Int]()

    val queue = mutable.Queue[(Int, Int)]()

    def leastInterval(tasks: Array[Char], n: Int): Int = {
      heap.addAll(tasks.groupBy(x => x).map(_._2.length))

      def rec(time: Int): Int =
        if (heap.isEmpty && queue.isEmpty) time
        else if (queue.nonEmpty && queue.head._2 < time) {
          val (task, _) = queue.dequeue
          heap.enqueue(task)

          val cur = heap.dequeue
          if (cur > 1) queue.enqueue((cur - 1, time + n))
          rec(time + 1)
        }
        else if (heap.nonEmpty) {
          val cur = heap.dequeue
          if (cur > 1) queue.enqueue((cur - 1, time + n))
          rec(time + 1)
        }
        else rec(time + 1)

      rec(0)
    }
  }

}
