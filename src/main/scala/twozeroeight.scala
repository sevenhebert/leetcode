class twozeroeight {

  class Trie() {
    import scala.annotation.tailrec
    import scala.collection.mutable

    case class Node(self: mutable.Map[Char, Node], var end: Boolean)

    val words: Node = Node(scala.collection.mutable.Map.empty, end = false)

    def insert(word: String): Unit = {
      @tailrec
      def rec(str: String, node: Node): Node =
        if (str.isEmpty) {
          node.end = true
          null
        }
        else {
          val update = node.self.updateWith(str.head) {
            case None => Some(Node(mutable.Map.empty, end = false))
            case node => node
          }.get

          rec(str.tail, update)
        }

      rec(word, words)
    }

    @tailrec
    private def _startsWith(str: String, node: Node): (Boolean, Node) =
      if (str.isEmpty) (true, node)
      else if (node.self.contains(str.head)) _startsWith(str.tail, node.self(str.head))
      else (false, node)

    def search(word: String): Boolean = {
      val (res, node) = _startsWith(word, words)
      res && node.end
    }

    def startsWith(prefix: String): Boolean = _startsWith(prefix, words)._1

  }

}
