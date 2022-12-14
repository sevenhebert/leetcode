class twozero {

  object Solution {

    def isValid(s: String): Boolean = {

      def rec(idx: Int, stk: List[Char]): Boolean =
        if (idx == s.length) stk.isEmpty
        else if (stk.isEmpty && (s(idx) == ')' || s(idx) == '}' || s(idx) == ']')) false
        else if (s(idx) == '(' || s(idx) == '{' || s(idx) == '[') rec(idx + 1, stk :+ s(idx))
        else if (s(idx) == ')' && stk.last == '(') rec(idx + 1, stk.dropRight(1))
        else if (s(idx) == '}' && stk.last == '{') rec(idx + 1, stk.dropRight(1))
        else if (s(idx) == ']' && stk.last == '[') rec(idx + 1, stk.dropRight(1))
        else false

      rec(0, List.empty)
    }

  }

}
