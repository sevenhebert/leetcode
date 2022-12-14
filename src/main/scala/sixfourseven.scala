class sixfourseven {

  object Solution {

    def countSubstrings(s: String): Int = {

      def expand(left: Int, right: Int, res: Int): Int =
        if (left < 0 || right >= s.length || s(left) != s(right)) res
        else expand(left - 1, right + 1, res + 1)

      (0 to s.length).fold(0)((acc, i) => acc + expand(i, i, 0) + expand(i, i + 1, 0))
    }

  }

}
