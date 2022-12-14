class oneseven {

  object Solution {

    private val digitToLetter = Map(
      '2' -> List("a", "b", "c"),
      '3' -> List("d", "e", "f"),
      '4' -> List("g", "h", "i"),
      '5' -> List("j", "k", "l"),
      '6' -> List("m", "n", "o"),
      '7' -> List("p", "q", "r", "s"),
      '8' -> List("t", "u", "v"),
      '9' -> List("w", "x", "y", "z")
    )

    def letterCombinations(digits: String): List[String] = {

      def combinations(ds: String, acc: List[String]): List[String] = ds.headOption match {
        case Some(digit) =>
          val update = acc.flatMap(ac => digitToLetter(digit).map(letter => ac + letter))
          combinations(ds.tail, update)
        case None => acc
      }

      if (digits.nonEmpty) combinations(digits, List.empty)
      else Nil
    }
  }

}
