class twoeleven {

  class WordDictionary() {

    import scala.annotation.tailrec
    import scala.collection.mutable

    case class Node(self: mutable.Map[Char, Node], var end: Boolean)

    val words: Node = Node(scala.collection.mutable.Map.empty, end = false)

    def addWord(word: String): Unit = {
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

    def search(word: String): Boolean = {
      println("word: " + word)
      def rec(str: String, node: Node): Boolean = {
        println("str: " + str)
        println("node: " + node.self)
        if (str.isEmpty) node.end
        else if (str.head == '.') node.self.keys.exists(k => rec(str.tail, node.self(k)))
        else if (node.self.contains(str.head)) rec(str.tail, node.self(str.head))
        else false
      }

      rec(word, words)
    }

  }

}
