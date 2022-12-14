class eightsevenfive {
  object Solution {
    def minEatingSpeed(piles: Array[Int], h: Int): Int = {

      val choices = 1 to piles.max

      def consumptionTime(rate: Double) = piles.fold(0)((acc, cur) => acc + math.ceil(cur / rate).toInt)

      def minSearch(li: Int, ri: Int): Int = {
        val window = ri - li
        val ci = (window / 2) + li
        val curTime = consumptionTime(choices(ci).toDouble)

        if (window <= 1 && curTime <= h) choices(li)
        else if (window <= 1) choices(ri)
        else if (curTime <= h) minSearch(li, ci) // eat fewer
        else minSearch(ci, ri) // eat more
      }

      minSearch(0, choices.length - 1)
    }

  }

}
