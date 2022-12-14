class five {

  object Solution {
    def longestPalindrome(s: String): String = {

      def rec(i: Int, j: Int, res: String): String = {
        if (i < 0 || j >= s.length || s(i) != s(j)) res
        else rec(i - 1, j + 1, s.slice(i, j + 1))
      }

      val mid = s.length / 2
      rec(mid, mid, s(mid).toString)
    }

  }

}
