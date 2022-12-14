class eightytwo {

  object Solution {
    def deleteDuplicates(head: ListNode): ListNode = {

      def skip(n: ListNode): ListNode =
        if (n == null || n.next == null) null
        else if (n.x == n.next.x) {
          n.next = n.next.next
          skip(n)
        }
        else n.next

      val init = new ListNode(-1, head)

      def rec(prev: ListNode, cur: ListNode): ListNode =
        if (cur == null) init.next
        else if (cur.next != null && cur.x == cur.next.x) {
          val update = skip(cur)
          rec(prev, update)
        }
        else {
          prev.next = cur
          rec(cur, cur.next)
        }

      rec(init, init.next)
    }
  }

  // [1,2,3,3,4,4,5]
  // [1,1,1,2,3]
  // []
  // [1,1]
}
