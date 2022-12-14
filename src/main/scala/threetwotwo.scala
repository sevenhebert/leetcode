import org.w3c.dom.css.Counter

class threetwotwo {

  object Solution {

    import collection.mutable

    def coinChange(coins: Array[Int], amount: Int): Int = {

      val dp = Array.fill(amount + 1)(amount + 1)
      dp.update(0, 0)

      (0 until amount + 1).foreach { a =>
        coins.foreach { coin =>
          if (a - coin >= 0) dp.update(a, math.min(dp(a), 1 + dp(a - coin)))
        }
      }

      if (dp(amount) == amount + 1) -1 else dp(amount)
    }
  }

}
