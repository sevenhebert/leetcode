class onethreethree {

  object Solution {

    import collection.mutable

    val seen: mutable.Set[Int] = mutable.Set[Int]()

    def rec(og: Node, clone: Node): Node =
      if (og == null || seen.contains(og.value)) clone
      else {
        val cur = new Node(og.value)
        seen.addOne(og.value)
        og.neighbors.foreach(nbr => cur.neighbors.appended(rec(nbr, clone)))
        cur
      }

    def cloneGraph(graph: Node): Node = rec(graph, new Node(graph.value))

  }

}
