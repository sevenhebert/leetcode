class twosevenone {

  class Codec {

    import collection.mutable

    // Encodes a list of strings to a single string.
    def encode(strs: List[String]): String = strs.collect({ case str if str.nonEmpty => s"${str.length}:$str" }).mkString

    // Decodes a single string to a list of strings.
    def decode(s: String): List[String] = {
      val res = mutable.ListBuffer[String]()

      def rec(chars: String): List[String] =
        if (chars.isEmpty) res.toList
        else {
          val Pattern = "^(0|[1-9][0-9]*:)(.*)".r
          chars match {
            case Pattern(delim, rest) =>
              val len = delim.dropRight(1).toInt
              println(s"len: $len")
              val (cur, next) = delim.splitAt(delim.dropRight(1).toInt)
              println(s"cur: $cur, next: $next")
              res.addOne(cur)
              rec(rest)
          }
        }

      rec(s)
    }

  }

}
