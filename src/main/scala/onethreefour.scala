class onethreefour {

//  object Solution {
//    def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int =
//      if (gas.sum - cost.sum < 0) -1
//      else gas.foldLeft((0, 0, 0))({ case ((idx, tank, start), curGas) =>
//        val fuelRemaining = tank + curGas - cost(idx)
//        if (fuelRemaining < 0) (idx + 1, 0, idx + 1)
//        else (idx + 1, fuelRemaining, start)
//      })._3
//  }
  object Solution {
    def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int =
      if (gas.sum - cost.sum < 0) -1
      else {
        var total = 0
        var start = 0
        var idx = 0

        while (idx < gas.length) {
          total = total + gas(idx) - cost(idx)
          idx += 1
          if (total < 0) {
            total = 0
            start = idx
          }
        }

        start
      }
  }

}
