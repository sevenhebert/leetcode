import scala.collection.mutable

class onefivefive {

  class MinStack() {

    import collection.mutable

    private val stk = mutable.ArrayBuffer[Int]()

    private val min = mutable.ArrayBuffer[Int]()

    def push(`val`: Int): Unit = {
      stk.addOne(`val`)
      if (min.isEmpty) min.addOne(`val`)
      else min.addOne(math.min(`val`, min(min.length - 1)))
    }

    def pop() = {
      stk.remove(stk.size - 1)
      min.remove(min.size - 1)
    }

    def top(): Int = stk(stk.length - 1)

    def getMin(): Int = min(min.length - 1)

  }

}
