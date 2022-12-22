class twotwo {
  object Solution {

    import collection.mutable

    def generateParenthesis(n: Int): List[String] = {

      val stk = mutable.ArrayBuffer[Char]()

      val res = mutable.ArrayBuffer[String]()

      def rec(open: Int, closed: Int): Unit = {
        if (open == n && closed == n) res.addOne(stk.mkString)
        if (open < n) {
          stk.addOne('(')
          rec(open + 1, closed)
          stk.remove(stk.length - 1)
        }
        if (closed < open) {
          stk.addOne(')')
          rec(open, closed + 1)
          stk.remove(stk.length - 1)
        }
      }

      rec(0, 0)
      res.toList
    }
  }

}
