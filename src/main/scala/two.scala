class two {

  object Solution {

    def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {

      val sentinal = new ListNode(1)

      def sumRem(left: Int, right: Int, rem: Int) = {
        val total = (left + right + rem).toString
        val remainder = if (total.length > 1) total.dropRight(1).toInt else 0
        val digit = if (total.length > 1) total.drop(1).toInt else total.toInt
        (digit, remainder)
      }

      def add(left: ListNode, right: ListNode, rem: Int, last: ListNode): ListNode = (left, right, rem) match {
        case (null, null, 0) => sentinal.next
        case (null, null, rem) =>
          val curNode = new ListNode(rem)
          last.next = curNode
          sentinal.next
        case (l, null, rem) =>
          val (curSum, curRem) = sumRem(l.x, 0, rem)
          val curNode = new ListNode(curSum)
          last.next = curNode
          add(left.next, null, curRem, curNode)
        case (null, r, rem) =>
          val (curSum, curRem) = sumRem(0, r.x, rem)
          val curNode = new ListNode(curSum)
          last.next = curNode
          add(null, r.next, curRem, curNode)
        case (l, r, rem) =>
          val (curSum, curRem) = sumRem(l.x, r.x, rem)
          val curNode = new ListNode(curSum)
          last.next = curNode
          add(l.next, r.next, curRem, curNode)
      }

      add(l1, l2, 0, sentinal)
    }
  }

}
