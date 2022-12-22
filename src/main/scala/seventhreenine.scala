class seventhreenine {

  object Solution {

    import collection.mutable

    def dailyTemperatures(temperatures: Array[Int]): Array[Int] = {

      val stk = mutable.Stack[(Int, Int)]()

      val res = Array.fill(temperatures.length)(0)

      var idx = 0

      while (idx < temperatures.length) {
        while (stk.nonEmpty && temperatures(idx) > stk.top._1) {
          res(stk.top._2) = idx - stk.top._2
          stk.pop
        }
        stk.push((temperatures(idx), idx))
        idx += 1
      }

      res
    }
  }

}
