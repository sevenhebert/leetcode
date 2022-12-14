class oneonefourthree {

  object Solution {

//    text1 = "(a[ac)e]eeee", text2 = "aaaace"
    // ace, ce, e

    import collection.mutable

    def longestCommonSubsequence(text1: String, text2: String): Int = {

//      val t1 = mutable.Set[Char]()
//      text1.foreach(t1.addOne)
//
//      val t2 = mutable.Set[Char]()
//      text2.foreach(t2.addOne)

      val (short, long) = if (text1.length < text2) (text1, text2) else (text2, text1)

      val shared = text1.intersect(text2).toSet



      def rec(si: Int, li: Int, count: Int): Int = {
        if (si == short.length || li == long.length) count
        else if (!shared.contains(short(si))) rec(si + 1, li, count)
        else if (!shared.contains(long(li))) rec(si + 1, li, count)
        else if (short(si) == long(li)) rec(si + 1, li + 1, count + 1)
        else rec(si, li + 1, count)
      }

      rec(0, 0, 0)

      short.map(char => char)
    }

  }

}
