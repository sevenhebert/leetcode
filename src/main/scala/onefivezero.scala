class onefivezero {

  object Solution {

    import collection.mutable

    private val stack = mutable.ListBuffer[Int]()

    def evalRPN(tokens: Array[String]): Int = tokens.headOption match {
      case Some("+") =>
        stack.addOne(stack.remove(stack.length - 2) + stack.remove(stack.length - 1))
        evalRPN(tokens.tail)
      case Some("-") =>
        stack.addOne(stack.remove(stack.length - 2) - stack.remove(stack.length - 1))
        evalRPN(tokens.tail)
      case Some("*") =>
        stack.addOne(stack.remove(stack.length - 2) * stack.remove(stack.length - 1))
        evalRPN(tokens.tail)
      case Some("/") =>
        stack.addOne(stack.remove(stack.length - 2) / stack.remove(stack.length - 1))
        evalRPN(tokens.tail)
      case Some(num) =>
        stack.addOne(num.toInt)
        evalRPN(tokens.tail)
      case None => stack.last
    }

  }
}
