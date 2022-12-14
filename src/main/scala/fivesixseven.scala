class fivesixseven {

  object Solution {

    import collection.mutable

    def checkInclusion(s1: String, s2: String): Boolean = {
      val s1Map = mutable.Map[Char, Int]()
      ('a' to 'z').foreach(char => s1Map.addOne(char -> 0))
      val s2Map = mutable.Map[Char, Int]()
      ('a' to 'z').foreach(char => s2Map.addOne(char -> 0))

      def increment(prev: Option[Int]): Option[Int] = prev match { case Some(v) => Some(v + 1); case None => Some(1) }
      def decrement(prev: Option[Int]): Option[Int] = prev match { case Some(v) => Some(v - 1); case None => Some(0) }

      s1.foreach(char => s1Map.updateWith(char)(increment))
      s2.take(s1.length).foreach(char => s2Map.updateWith(char)(increment))

      var matches = s1Map.foldLeft(0) { case (total, (k, v)) => if (s2Map(k) == v) total + 1 else total }

      def rec(i: Int, j: Int): Boolean =
        if (matches == 26) true
        else if (j == s2.length) false
        else {
          val droppedChar = s2(i)
          s2Map.updateWith(droppedChar)(decrement)
          if (s1Map(droppedChar) == s2Map(droppedChar)) matches += 1
          if (s1Map(droppedChar) - 1 == s2Map(droppedChar)) matches -= 1

          val addedChar = s2(j)
          s2Map.updateWith(addedChar)(increment)
          if (s1Map(addedChar) == s2Map(addedChar)) matches += 1
          if (s1Map(addedChar) + 1 == s2Map(addedChar)) matches -= 1

          rec(i + 1, j + 1)
        }

      if (s1.length > s2.length) false
      else rec(0, s1.length)
    }
  }

}
