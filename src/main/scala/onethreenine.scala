class onethreenine {

  object Solution {

//    import collection.mutable

    def wordBreak(s: String, wordDict: List[String]): Boolean = {

      val wd = wordDict.toSet

//      val seen = mutable.Set[String]()

      def rec(i: Int, words: String, seen: Set[String]): Boolean = {
        println(s"i: $i, words: $words")

        if (words.isEmpty) true
        else if (i == words.length) false
        else if (seen.contains(s"$i, ${words.slice(0, i + 1)}")) rec(i + 1, words, seen)
        else {
          val update = seen + s"$i, ${words.slice(0, i + 1)}"
          if (!wd.contains(words.slice(0, i + 1))) rec(i + 1, words, update)
          else rec(0, words.substring(i + 1), update) || rec(i + 1, words, update)
        }
      }

      rec(0, s, Set.empty)
    }
  }

}
